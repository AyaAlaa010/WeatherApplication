package com.example.weatherapplication.ui.favourit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapplication.R
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.databinding.FavouriteDetailsBinding
import com.example.weatherapplication.ui.currentui.CurrentAdapter
import com.example.weatherapplication.viewmodels.HourlyViewModel
import com.example.weatherapplication.viewmodels.WeatherViewModel

class FavouriteLocationDetails : AppCompatActivity() {
    lateinit var binding:FavouriteDetailsBinding
    private lateinit var viewModel: WeatherViewModel
    private lateinit var hourlyViewModel: HourlyViewModel
    var myadapter: CurrentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.favourite_details)

            viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
            hourlyViewModel = ViewModelProvider(this).get(HourlyViewModel::class.java)

        val latlanString=intent.getStringExtra("details")
        val splitlatlan=latlanString?.split("+")

        initViews(splitlatlan?.get(0)?.toDouble()!!, splitlatlan?.get(1)?.toDouble()!!, "minutely,hourly", "en", "standard")
        observeViewModel()
        hourlyViewModel.getWeather(splitlatlan?.get(0)?.toDouble()!!, splitlatlan?.get(1)?.toDouble()!!, "minutely,current,daily,alerts", "en",  "standard")
        //StreetDateClass(requireContext()).setUnites())
        observeHourly()



    }


    private fun initViews(lat: Double, lon: Double, exclude: String, lang: String, unites: String) {
        viewModel.getWeather(lat,
            lon,
            exclude,
            lang, unites
        )
    }

    //



    fun observeHourly() {
        hourlyViewModel.weatherLiveData.observeForever {
            Log.i("TAGsssssssssss", "onCreateView: " + it.hourly.size)
            var currentHourListt = it.hourly
            myadapter = CurrentAdapter(currentHourListt, this)
            val layoutManager =
                LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

            binding.recyclerHourFavDetails.adapter = myadapter
            binding.recyclerHourFavDetails.layoutManager = layoutManager



        }






    }

    private fun observeViewModel() {

        viewModel.weatherLiveData.observeForever {

                var link =
                    "http://openweathermap.org/img/wn/" + (it.current?.weather?.get(0)?.icon) + "@2x.png"
                Glide.with(this).load(link).into(binding?.imgIconFavDetails!!)
                Log.d("TAG", "observeViewModel: ${it.current?.weather?.get(0)?.description}")

            binding?.statusCurrentFavDetails?.text = it.current?.weather?.get(0)?.description

    binding?.currentHumedityFavDetails?.text = "Humidity:" + it.current?.humidity.toString() + "%"
    binding?.currentClouds?.text = "Clouds:" + it.current?.clouds.toString() + "%"
    binding?.currentPressureFavDetails?.text = "pressure:" + it.current?.pressure.toString()
            binding?.currentClouds?.text = "Clouds:" + it.current?.clouds.toString() + "%"


            val convertedDate = StreetDateClass(this).getDateTime((it.current?.dt).toString())
            binding?.currentDateFavDetails?.text = convertedDate
            val address = StreetDateClass(this).getStreetName(it.lat!!, it.lon!!)
            binding.currentAddressFavDetails.text = address



            if (StreetDateClass(this).setTemperature() == 1) {//c
                // K - 273.15
                val degree= it.current?.temp?.minus(273.15)
                val number:Double=String.format("%.2f", degree).toDouble()

                binding?.currentDegreeFavDetails?.text = number.toString() + " C"



            } else if (StreetDateClass(this).setTemperature() == 2) {//k
                val number:Double=String.format("%.2f", it.current?.temp).toDouble()

                binding?.currentDegreeFavDetails?.text = number.toString() + " K"


            } else if (StreetDateClass(this).setTemperature() == 3) {//f

                //°F = (K − 273.15) × 9/5 + 32

                val degree=(((it.current?.temp)?.minus(273.15))?.times(9/3)?.plus(32))
                val number:Double=String.format("%.2f", degree).toDouble()

                binding?.currentDegreeFavDetails?.text = number.toString() + " F"


            }

//wind speed
            if (StreetDateClass(this).setWindSpeed() == 1) {//c
                // mile= sec*2.236936
                val number:Double=String.format("%.2f", it.current?.windSpeed).toDouble()
                binding?.currentWindFavDetails?.text = "wind:" +number.toString() + " m/s"

            } else if (StreetDateClass(this).setWindSpeed() == 2) {//k

                val degree= it.current?.windSpeed?.times(2.236936)
                val number:Double=String.format("%.2f",degree).toDouble()


                binding?.currentWindFavDetails?.text = "wind:" + number.toString() + " m/h"


            }


        }








    }}