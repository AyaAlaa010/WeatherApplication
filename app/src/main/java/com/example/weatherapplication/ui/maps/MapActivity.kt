package com.example.weatherapplication.ui.maps

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnCompleteListener
import java.io.IOException
import java.util.ArrayList





import com.example.weatherapplication.R
import com.example.weatherapplication.data.local.favouriteroom.FavouriteDataBase
import com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.databinding.ActivityMapTestBinding
import com.example.weatherapplication.ui.mainui.MainActivity

class MapActivity : AppCompatActivity(), OnMapReadyCallback ,View.OnClickListener{
    lateinit var binding: ActivityMapTestBinding

    override fun onMapReady(googleMap: GoogleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onMapReady: map is ready")
        mMap = googleMap
        if (mLocationPermissionsGranted) {
            deviceLocation
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            mMap!!.isMyLocationEnabled = true
            mMap!!.uiSettings.isMyLocationButtonEnabled = false
            init()
        }


        binding.btMapConfirm.setOnClickListener(this);


    }


    //vars
    private var mLocationPermissionsGranted = false
    private var mMap: GoogleMap? = null
    private var mFusedLocationProviderClient: FusedLocationProviderClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_map_test)
        locationPermission

        init()
    }

    private fun init() {
        Log.d(TAG, "init: initializing")
        binding.inputSearch!!.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE || keyEvent.action == KeyEvent.ACTION_DOWN || keyEvent.action == KeyEvent.KEYCODE_ENTER
            ) {

                //execute our method for searching
                geoLocate()
            }
            false
        }
        hideSoftKeyboard()
    }

    private fun geoLocate() {
        Log.d(TAG, "geoLocate: geolocating")
        val searchString =  binding.inputSearch!!.text.toString()
        val geocoder = Geocoder(this)
        var list: List<Address> = ArrayList()
        try {
            list = geocoder.getFromLocationName(searchString, 1)
        } catch (e: IOException) {
            Log.e(TAG, "geoLocate: IOException: " + e.message)
        }
        if (list.size > 0) {
            val address = list[0]
            Log.d(TAG,
                "geoLocate: found a location: $address")

            val sharedPreferences: SharedPreferences = getSharedPreferences("weather", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("latMap",address.latitude.toString() )
            editor.putString("lonMap",address.longitude.toString() )
            editor.apply()
            editor.commit()

            //



            moveCamera(LatLng(address.latitude, address.longitude),
                DEFAULT_ZOOM,
                address.getAddressLine(0))
        }
    }

    private val deviceLocation: Unit
        private get() {
            Log.d("TAaG", "getDeviceLocation: getting the devices current location")
            mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
            try {
                if (mLocationPermissionsGranted) {
                    val location = mFusedLocationProviderClient!!.lastLocation


                    location.addOnCompleteListener(OnCompleteListener {
                        if (it.isSuccessful) {
                            Log.d(TAG, "onComplete: found location!")
                            val currentLocation = it.result as Location
                            moveCamera(LatLng(currentLocation.latitude,
                                currentLocation.longitude),
                                DEFAULT_ZOOM, "mylocation")
                        } else {
                            Log.d(TAG, "onComplete: current location is null")
                            Toast.makeText(this@MapActivity,
                                "unable to get current location",
                                Toast.LENGTH_SHORT).show()
                        }


                    })

                }
            } catch (e: SecurityException) {
                Log.e(TAG, "getDeviceLocation: SecurityException: " + e.message)
            }
        }

    private fun moveCamera(latLng: LatLng, zoom: Float, title: String) {
        Log.d(TAG,
            "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude)
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom))
        if (title != "mylocation") {
            val options = MarkerOptions().position(latLng).title(title)
            mMap!!.addMarker(options)
        }

        hideSoftKeyboard()
    }

    private fun initMap() {
        Log.d(TAG, "initMap: initializing map")
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this@MapActivity)
    }

    private val locationPermission: Unit
        private get() {
            Log.d(TAG, "getLocationPermission: getting location permissions")
            val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION)
            if (ContextCompat.checkSelfPermission(this.applicationContext,
                    FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            ) {
                if (ContextCompat.checkSelfPermission(this.applicationContext,
                        COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                ) {
                    mLocationPermissionsGranted = true
                    initMap()
                } else {
                    ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE)
                }
            } else {
                ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE)
            }
        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(TAG, "onRequestPermissionsResult: called.")
        mLocationPermissionsGranted = false
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.size > 0) {
                    var i = 0
                    while (i < grantResults.size) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionsGranted = false
                            Log.d(TAG, "onRequestPermissionsResult: permission failed")
                            return
                        }
                        i++
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted")
                    mLocationPermissionsGranted = true
                    //initialize our map
                    initMap()
                }
            }
        }
    }

    private fun hideSoftKeyboard() {
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    companion object {
        private const val TAG = "MapActivity"
        private const val FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
        private const val COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1234
        private const val DEFAULT_ZOOM = 15f
    }



    override fun onClick(view: View?) {
        if(view?.id  == R.id.bt_map_confirm) {



            if(StreetDateClass(this).mapDifferentActivity()==2){
                val sharedPreferences: SharedPreferences = getSharedPreferences("weather", Context.MODE_PRIVATE)

                var searchLat = sharedPreferences.getString("latMap","0")
                var searchLon=sharedPreferences.getString("lonMap","0")

                var favLocation=searchLat.toString()+"+"+searchLon.toString()
                    var favouriteEntity=FavouriteEntity(favLocation)
                FavouriteDataBase.getInstance(this).favouriteDao().addLocation(favouriteEntity)

                Toast.makeText(this, "new Favourite Location added", Toast.LENGTH_SHORT).show()
                    setResult(RESULT_OK)
                    finish()
            }else{

                    val intent = Intent(this, MainActivity::class.java)
                    Log.i(TAG, "onClick: nnnn"+"setting")
                    startActivity(intent)
                    finish()}


        }
    }
}