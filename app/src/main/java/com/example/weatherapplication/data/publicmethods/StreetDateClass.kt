package com.example.weatherapplication.data.publicmethods

import android.content.Context
import android.content.SharedPreferences
import android.location.Geocoder
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import java.text.SimpleDateFormat
import java.util.*

class StreetDateClass(var context: Context) {




    fun setTemperature():Int {
        val tempsharedPreferences:SharedPreferences = context.getSharedPreferences("temp", 0)

        var value = tempsharedPreferences.getInt("temp",0)
        if(value==1){
            return 1
        }
        else if(value==2){

            return 2
        }
        else if(value==3){

            return 3

        }
        else
            return 1


    }



    fun setWindSpeed():Int {

        val sharedPreferencesSpeed:SharedPreferences = context.getSharedPreferences("Speed", 0)

        var value = sharedPreferencesSpeed.getInt("Speed",0)
        if(value==1){
            return 1
        }
        else if(value==2){

            return 2
        }
       else{

           return 1
       }


    }





//    fun setUnites():String {
//         var unitSet:String="standard"
//
//        val shared: SharedPreferences = context.getSharedPreferences("cc",Context.MODE_PRIVATE)
//        var value = shared.getInt("genderSP",0)
//        if(value==1){
//            unitSet="standard"
//
//        }
//        else if(value==2){
//
//
//            unitSet="metric"
//
//        }
//        else if(value==3){
//
//            unitSet="imperial"
//
//
//        }
//
//        return unitSet
//
//    }
//



    fun getLocation():String {

//default the current
        val currentsharedPreferences: SharedPreferences = context.getSharedPreferences("arf",Context.MODE_PRIVATE)
         val latitudeLocation = currentsharedPreferences.getFloat("latt",0.0f)
         val langtitudeLocation = currentsharedPreferences.getFloat("lonn",0.0f)



        var locationType:String=latitudeLocation.toString()+"+"+langtitudeLocation.toString()



        // get the valuse of search location
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("MapLocation", Context.MODE_PRIVATE)

        var searchLat = sharedPreferences.getFloat("latMap",latitudeLocation)
        var searchLon=sharedPreferences.getFloat("lonMap",langtitudeLocation)

        // key location  for choose

        val    sharedPreferencesLocation : SharedPreferences = context.getSharedPreferences("location", 0)

        val locationValue = sharedPreferencesLocation!!.getInt("type", 0)




        if(locationValue==1){
            locationType=searchLat.toString()+"+"+searchLon.toString()
        }
        else if(locationValue==2){


            locationType=latitudeLocation.toString()+"+"+langtitudeLocation.toString()
        }

        return locationType

    }

fun mapDifferentActivity():Int{

    val    sharedPreferencesLocation : SharedPreferences = context.getSharedPreferences("location", 0)

    val locationValue = sharedPreferencesLocation!!.getInt("type", 0)


    if(locationValue==1){
        return 1
    }
    else if(locationValue==2){
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


}