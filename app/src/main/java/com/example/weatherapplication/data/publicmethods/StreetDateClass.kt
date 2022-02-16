package com.example.weatherapplication.data.publicmethods

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.location.Geocoder
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import java.text.SimpleDateFormat
import java.util.*

class StreetDateClass(var context: Context) {
    // used for all stored data in shared preferenced
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("weather", 0)

    //celsuis or kelvin or farhentaire
    fun setTemperature(): Int {
        // val tempsharedPreferences:SharedPreferences = context.getSharedPreferences("temp", 0)

        var value = sharedPreferences.getInt("temp", 1)
        if (value == 1) {
            return 1
        } else if (value == 2) {

            return 2
        } else if (value == 3) {

            return 3

        } else
            return 1


    }
    //m/s or m/h
    fun setWindSpeed(): Int {

        //val sharedPreferencesSpeed:SharedPreferences = context.getSharedPreferences("Speed", 0)

        var value = sharedPreferences.getInt("Speed", 1)
        if (value == 1) {
            return 1
        } else if (value == 2) {

            return 2
        } else {

            return 1
        }


    }

    // action for map or gps
    fun getLocation(): String {
        //default the current
        val latitudeLocation = sharedPreferences.getString("latCurrent", "0")
        val langtitudeLocation = sharedPreferences.getString("lonCurrent", "0")


        var locationType: String = "0"


        // get the valuse of search location im map activity
        var searchLat = sharedPreferences.getString("latMap", latitudeLocation)
        var searchLon = sharedPreferences.getString("lonMap", langtitudeLocation)

        // choose map or gps
        val locationValue = sharedPreferences!!.getInt("typeLocation", 2)




        if (locationValue == 1) {
            locationType = searchLat + "+" + searchLon
        } else if (locationValue == 2) {


            locationType = latitudeLocation + "+" + langtitudeLocation
        }

        return locationType

    }

    //choose between go to favourite or main (current fragment)
    fun mapDifferentActivity(): Int {

        val locationValue = sharedPreferences!!.getInt("typeLocation", 0)


        if (locationValue == 1) {
            return 1
        } else if (locationValue == 2) {
            return 2

        }
        return 1
    }


    fun getStreetName(lat: Double, lon: Double): String {
        val geocoder = Geocoder(context)
        val addresses = geocoder.getFromLocation(lat, lon, 1)
        if (addresses.isEmpty()) return "empty address"
        val address = addresses[0]
        val streetName = address.getAddressLine(0)
        Log.i("lat lang", "onMapClick: $streetName")
        return streetName
        //  tvStreetName.setText(streetName)

    }


    fun getDateTime(s: String): String? {
        //dd/MM/yyyy hh:mm:ss
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date((s).toLong() * 1000)
            return sdf.format(netDate)

        } catch (e: Exception) {
            return e.toString()
        }

    }

    fun getLanguage(): String {

        val sharedPreferences: SharedPreferences = context.getSharedPreferences("Settings", 0)
        val language = sharedPreferences.getString("My_Lang", "")

        return language!!


    }
}