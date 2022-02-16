package com.example.weatherapplication.ui.currentui

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.Current
import com.example.weatherapplication.R
import com.example.weatherapplication.data.local.current.CurrentDataBase
import com.example.weatherapplication.data.local.current.CurrentEntity
import com.example.weatherapplication.data.local.favouriteroom.FavouriteDataBase
import com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.databinding.FragmentCurrentBinding
import com.example.weatherapplication.internetconnection.InternetHandeling
import com.example.weatherapplication.ui.mainui.MainActivity
import com.example.weatherapplication.ui.mainui.Settings
import com.example.weatherapplication.viewmodels.HourlyViewModel
import com.example.weatherapplication.viewmodels.WeatherViewModel
import com.google.android.gms.location.*
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import java.util.*


class CurrentFragment : Fragment() {
    lateinit var binding: FragmentCurrentBinding
    var myadapter: CurrentAdapter? = null
    private lateinit var viewModel: WeatherViewModel
    private lateinit var hourlyViewModel: HourlyViewModel
    lateinit var mfusedLocationProviderclient: FusedLocationProviderClient
    val TAG = "current"
    var language = "en"
    var currentEntity = CurrentEntity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (InternetHandeling.checkForInternet(requireContext())) {

            Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
            initOnlineData()

        } else {
            Toast.makeText(requireContext(), "Disconnected", Toast.LENGTH_SHORT).show()

            initoflineData(currentEntity)
            //offlineHour()

        }


    }

    fun initOnlineData() {

        activity?.let {
            viewModel = ViewModelProvider(it).get(WeatherViewModel::class.java)
            hourlyViewModel = ViewModelProvider(it).get(HourlyViewModel::class.java)
        }


        if (StreetDateClass(requireContext()).getLanguage().equals("en")) {
            language = "en"

        } else if (StreetDateClass(requireContext()).getLanguage().equals("ar")) {
            language = "ar"

        }

        var storedLocation = StreetDateClass(requireContext()).getLocation()
        var splitItems = storedLocation.split("+")
        Log.i(TAG, "onViewCreated: lat=====" + splitItems.get(0))
        initViews(splitItems.get(0).toDouble(), splitItems.get(1).toDouble(), "minutely,hourly", language, "standard")
        observeViewModel()
        hourlyViewModel.getWeather(splitItems.get(0).toDouble(), splitItems.get(1).toDouble(), "minutely,current,daily,alerts", language, "standard")
        //StreetDateClass(requireContext()).setUnites())
        observeHourly()


    }


    private fun checkSettingAndStartLocationUpdate() {
        val locationSettingsRequest =
            LocationSettingsRequest.Builder().addLocationRequest(locationRequest!!).build()
        val settingsClient: SettingsClient = LocationServices.getSettingsClient(requireContext())
        settingsClient.checkLocationSettings(locationSettingsRequest).addOnSuccessListener(
            OnSuccessListener<Any?> {
                startLocationUpdates()
            }).addOnFailureListener(
            OnFailureListener { e ->
                val errorMessage = e.localizedMessage
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
                Log.i(TAG, "onFailure: $errorMessage")
            })
    }

    fun askLocationPermision() {
        if (ContextCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            lastLocation
            checkSettingAndStartLocationUpdate()
        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                10)
        }
    }

    //know the action of the user on permision
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //  result code -->refers to the code i made when send permision to user
        //grantresults--->reurn 0 if user not making permision  and more than zero if accept permission
        if (requestCode == 10 && grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            lastLocation
            checkSettingAndStartLocationUpdate()
        }

    }
///


    private val lastLocation: Unit
        private get() {
            //make sure that i take the permission before get the last location
            if (ActivityCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {

                return
            }
            mfusedLocationProviderclient?.getLastLocation()
                ?.addOnSuccessListener(OnSuccessListener<Location?> { location ->
                    if (location == null) {
                        Toast.makeText(requireContext(), " no access", Toast.LENGTH_LONG).show()
                        return@OnSuccessListener
                    }
                    Log.i(TAG, "onSuccess: " + location.latitude + "'" + location.latitude)

                    val sharedPreferences: SharedPreferences =
                        requireContext().getSharedPreferences("weather", Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("latCurrent", location.latitude.toString())
                    editor.putString("lonCurrent", location.latitude.toString())
                    editor.apply()
                    editor.commit()

                })?.addOnFailureListener(OnFailureListener { e ->
                    val errorMessage = e.localizedMessage
                    Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
                    Log.i(TAG, "onFailure: $errorMessage")
                })
        }

    //  get location updates
    var locationRequest: LocationRequest? = null
    private fun initLocationRequest() {
        locationRequest = LocationRequest.create()
        locationRequest!!.setInterval(4000)
        locationRequest!!.setFastestInterval(2000)
        locationRequest!!.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
    }


    //start location and stop location
    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        mfusedLocationProviderclient?.requestLocationUpdates(locationRequest!!,
            locationCallback,
            Looper.getMainLooper())
    }

    private fun stopLocationUpdates() {
        mfusedLocationProviderclient?.removeLocationUpdates(locationCallback)
    }

    var locationCallback: LocationCallback = object : LocationCallback() {
        // return the update
        override fun onLocationResult(locationResult: LocationResult) { // back after a specified time
            super.onLocationResult(locationResult)
            val late = locationResult.lastLocation.latitude
            val lng = locationResult.lastLocation.longitude
            Log.i(TAG, "onLocationResult: $late,$lng")
            val mylatlang = "latitude= $late \nlangitude= $lng"
           // Toast.makeText(requireContext(), mylatlang, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLocationUpdates()
    }

    override fun onStart() {
        super.onStart()
        initLocationRequest()
        mfusedLocationProviderclient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        askLocationPermision()
    }


    fun observeHourly() {
        hourlyViewModel.weatherLiveData.observe(viewLifecycleOwner, Observer {
            var currentHourListt = it.hourly
            myadapter = CurrentAdapter(currentHourListt, requireContext())
            val layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            binding.recyclerHourCurrent.adapter = myadapter
            binding.recyclerHourCurrent.layoutManager = layoutManager
        })
    }

    private fun observeViewModel() {
        viewModel.weatherLiveData.observe(viewLifecycleOwner, Observer {

            CurrentDataBase.getInstance(requireContext()).currentDao().deleteAll()

            context?.let { context ->
                var link = "http://openweathermap.org/img/wn/" + (it.current?.weather?.get(0)?.icon) + "@2x.png"
                Glide.with(context).load(link).into(binding?.imgIcon!!)
                currentEntity.currentIcon = link
                Log.d("TAG", "observeViewModel: ${it.current?.weather?.get(0)?.description}")
            }
            val convertedDate =
                StreetDateClass(requireContext()).getDateTime((it.current?.dt).toString())
            val address = StreetDateClass(requireContext()).getStreetName(it.lat!!, it.lon!!)
//room
            currentEntity.currentDescription = it.current?.weather?.get(0)?.description!!
            currentEntity.currentHumedity = it.current?.humidity!!
            currentEntity.currentPressure = it.current?.pressure!!
            currentEntity.currentCloud = it.current?.clouds!!
            currentEntity.key = it.current?.weather!!.get(0).id!!
            currentEntity.currentDate = convertedDate!!
            currentEntity.currentAddress = address

            if (StreetDateClass(requireContext()).setTemperature() == 1) {//c
                // K - 273.15
                val degree = it.current?.temp?.minus(273.15)
                binding?.currentDegree?.text = degree?.toInt().toString() + getString(R.string.c)
                currentEntity.currentTemp = degree?.toInt().toString() + getString(R.string.c)

            } else if (StreetDateClass(requireContext()).setTemperature() == 2) {//k

                binding?.currentDegree?.text = it.current?.temp?.toInt().toString() + getString(R.string.k)
                currentEntity.currentTemp = it.current?.temp?.toInt().toString() + getString(R.string.k)

            } else if (StreetDateClass(requireContext()).setTemperature() == 3) {//f
                //°F = (K − 273.15) × 9/5 + 32
                val degree = (((it.current?.temp)?.minus(273.15))?.times(9 / 3)?.plus(32))
                binding?.currentDegree?.text = degree?.toInt().toString() + getString(R.string.f)
                currentEntity.currentTemp = degree?.toInt().toString() + getString(R.string.f)
            }

            //wind speed
            if (StreetDateClass(requireContext()).setWindSpeed() == 1) {//c
                // mile= sec*2.236936
                binding?.currentWind?.text = getString(R.string.wind_speed) + " : " + it.current?.windSpeed?.toInt().toString() + getString(R.string.meter_sec)
                currentEntity.currentWind = getString(R.string.wind_speed) + " : " + it.current?.windSpeed?.toInt().toString() + getString(R.string.meter_sec)

            } else if (StreetDateClass(requireContext()).setWindSpeed() == 2) {//k

                val degree = it.current?.windSpeed?.times(2.236936)
                binding?.currentWind?.text = getString(R.string.wind_speed) + " : " + degree?.toInt().toString() + getString(
                        R.string.mil_hour)
                currentEntity.currentWind = getString(R.string.wind_speed) + " : " + degree?.toInt().toString() + getString(
                        R.string.mil_hour)
            }

            CurrentDataBase.getInstance(requireContext()).currentDao().addLocation(currentEntity)
            //  end room
            binding?.statusCurrent?.text = it.current?.weather?.get(0)?.description
            binding?.currentHumedity?.text = getString(R.string.humidity) + " : " + it.current?.humidity.toString() + "%"
            binding?.currentClouds?.text = getString(R.string.clouds) + " : " + it.current?.clouds.toString() + "%"
            binding?.currentTempMin?.text = getString(R.string.uvi) + ":" + it.current?.uvi.toString()
            binding?.currentPressure?.text = getString(R.string.pressure) + " : " + it.current?.pressure.toString()
            binding?.currentDate?.text = convertedDate
            binding.currentAddress.text = address

        })
    }


    fun initoflineData(currentEntity: CurrentEntity) {
        var currentArray = CurrentDataBase.getInstance(requireContext()).currentDao().getCurrentLocation() as ArrayList<CurrentEntity>

        binding.currentWind.text = currentArray.get(0).currentWind
        binding.currentClouds.text = getString(R.string.clouds) + " : " + currentArray.get(0).currentCloud.toString()
        binding.currentPressure.text = getString(R.string.pressure) + " : " + currentArray.get(0).currentPressure.toString()
        binding.currentHumedity.text = getString(R.string.humidity) + " : " + currentArray.get(0).currentHumedity.toString()
        binding.currentDegree.text = currentArray.get(0).currentTemp
        binding.currentDate.text = currentArray.get(0).currentDate
        binding.currentAddress.text = currentArray.get(0).currentAddress
        binding.statusCurrent.text = currentArray.get(0).currentDescription
        Glide.with(this).load(currentArray.get(0).currentIcon).into(binding?.imgIcon!!)
    }

    private fun initViews(lat: Double, lon: Double, exclude: String, lang: String, unites: String) {
        viewModel.getWeather(lat,
            lon,
            exclude,
            lang, unites
        )
    }
}




