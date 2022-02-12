package com.example.weatherapplication.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.AllResponse
import com.example.weatherapplication.constant.API_KEY
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.data.remote.RetrofitClient
import com.example.weatherapplication.ui.currentui.CurrentAdapter
import com.example.weatherapplication.ui.currentui.CurrentFragment
import com.example.weatherapplication.ui.mainui.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WeatherRepo() {
    private val TAG = "WeatherRepo"
    val weatherLiveData = MutableLiveData<AllResponse>()
    fun getWeather(lat: Double,lon:Double,exclude:String,lang:String,unites:String) {




        GlobalScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.getApiService().getAllWeather(lat,lon,exclude,lang,unites,API_KEY)
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.d(TAG, "onResponse: ${it}")
                        Log.i(TAG, "getWeather: "+response.body().toString())
                        weatherLiveData.value = it
                    }
                }
                else{
                    Log.i(TAG, "getWeather: "+response.errorBody())


                }
            }

        }
    }

}