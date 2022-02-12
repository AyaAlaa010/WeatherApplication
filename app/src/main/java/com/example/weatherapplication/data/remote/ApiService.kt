package com.example.weatherapplication.data.remote

import android.telecom.Call
import com.example.example.AllResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

@GET("data/2.5/onecall")
suspend   fun getAllWeather(
    @Query("lat") lat: Double,
    @Query("lon") lon: Double,
     @Query("exclude") exclude: String,
    @Query("lang") lang: String,
     @Query("units") units: String,
    @Query("appid") key: String

): Response<AllResponse>

}