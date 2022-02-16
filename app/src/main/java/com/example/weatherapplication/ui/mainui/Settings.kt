package com.example.weatherapplication.ui.mainui;

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.ActivitySetBinding
import com.example.weatherapplication.ui.maps.MapActivity
import java.util.*


class Settings : AppCompatActivity() {

    var liveData = MutableLiveData<String>()
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    lateinit var binding: ActivitySetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_set)
        chooseLocation()
        chooseTemperature()
        choosewindSpeed()


    }

    //locationClicked

    fun chooseLocation() {


        sharedPreferences = getSharedPreferences("weather", 0)

        val locationValue = sharedPreferences!!.getInt("typeLocation", 0)
        editor = sharedPreferences!!.edit()

        if (locationValue == 1) {
            binding.toggeMap!!.setChecked(true)
        } else if (locationValue == 2) {
            binding.toggelGps!!.setChecked(true)
        }


    }

    fun locationClicked(view: View?) {

        if (binding.toggeMap!!.isChecked) {
            editor!!.putInt("typeLocation", 1)
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)

        } else if (binding.toggelGps!!.isChecked) {
            editor!!.putInt("typeLocation", 2)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Save the changes
        editor!!.commit()
    }


// TemperatureClicked
//,c,k,f

    fun chooseTemperature() {


        sharedPreferences = getSharedPreferences("weather", 0)

        val unitesValue = sharedPreferences!!.getInt("temp", 0)
        editor = sharedPreferences!!.edit()

        if (unitesValue == 1) {
            binding.toggeDegreeCelsiuss!!.setChecked(true)
        } else if (unitesValue == 2) {
            binding.toggelKelvinn!!.setChecked(true)
        } else if (unitesValue == 3) {
            binding.toggelFahrenheitt!!.setChecked(true)
        }

    }


    fun TemperatureClicked(view: View?) {

        if (binding.toggeDegreeCelsiuss!!.isChecked) {
            editor!!.putInt("temp", 1)
        } else if (binding.toggelKelvinn!!.isChecked) {
            editor!!.putInt("temp", 2)

        } else if (binding.toggelFahrenheitt!!.isChecked) {
            editor!!.putInt("temp", 3)

        }
        // Save the changes
        editor!!.commit()
    }

//windClicked


    fun choosewindSpeed() {


        sharedPreferences = getSharedPreferences("weather", 0)

        val speedValue = sharedPreferences!!.getInt("Speed", 0)
        editor = sharedPreferences!!.edit()

        if (speedValue == 1) {
            binding.toggeMs!!.setChecked(true)
        } else if (speedValue == 2) {
            binding.toggelMh!!.setChecked(true)
        }


    }

    fun windClicked(view: View?) {

        if (binding.toggeMs!!.isChecked) {
            editor!!.putInt("Speed", 1)

        } else if (binding.toggelMh!!.isChecked) {
            editor!!.putInt("Speed", 2)

        }

        // Save the changes
        editor!!.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()


    }
}
