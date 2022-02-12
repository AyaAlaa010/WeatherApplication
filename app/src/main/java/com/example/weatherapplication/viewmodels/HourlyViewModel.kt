package com.example.weatherapplication.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example.AllResponse
import com.example.weatherapplication.repo.WeatherRepo

class HourlyViewModel: ViewModel() {
    var weatherLiveData = MutableLiveData<AllResponse>()
    private val repo = WeatherRepo();

    fun getWeather(lat: Double,lon:Double,exclude:String,lang:String,unites:String) {
        repo.getWeather(lat,lon,exclude,lang,unites)
        weatherLiveData = repo.weatherLiveData

    }
}