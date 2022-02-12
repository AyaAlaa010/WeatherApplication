

package com.example.weatherapplication.ui.mainui;

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.example.AllResponse
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.ActivitySetBinding
import com.example.weatherapplication.ui.maps.Map2


class Settings : AppCompatActivity() {

    var liveData = MutableLiveData<String>()
//sharedPreferencesLocation
var sharedPreferencesLocation: SharedPreferences? = null
    var editorLocation: SharedPreferences.Editor? = null
var sharedPreferencesSpeed: SharedPreferences? = null
    var editorSpeed: SharedPreferences.Editor? = null
    var tempsharedPreferences: SharedPreferences? = null
    var editortemp: SharedPreferences.Editor? = null

    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    lateinit var binding: ActivitySetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_set)
      //  chooseUnites();
        chooseLocation()
        chooseTemperature()
        choosewindSpeed()
    }

//    fun chooseUnites(){
//
//
//        sharedPreferences = getSharedPreferences("cc", 0)
//
//        val unitesValue = sharedPreferences!!.getInt("genderSP", 0)
//        editor = sharedPreferences!!.edit()
//
//        if (unitesValue == 1) {
//            binding.toggeUnitesStandard!!.setChecked(true)
//        } else if (unitesValue == 2) {
//            binding.toggelUnitesMetric!!.setChecked(true)
//        }
//        else if (unitesValue == 3) {
//            binding.toggelUnitesImperial!!.setChecked(true)
//        }
//
//    }




//    fun unitesClicked(view: View?) {
//
//        if ( binding.toggeUnitesStandard!!.isChecked) {
//            editor!!.putInt("genderSP", 1)
//            liveData.value="standard"
//        } else if ( binding.toggelUnitesMetric!!.isChecked) {
//            editor!!.putInt("genderSP", 2)
//            liveData.value="metric"
//
//        }
//        else if (binding.toggelUnitesImperial!!.isChecked) {
//            editor!!.putInt("genderSP", 3)
//            liveData.value="imperial"
//
//        }
//        // Save the changes
//        editor!!.commit()
//    }


    //locationClicked

    fun chooseLocation(){


        sharedPreferencesLocation = getSharedPreferences("location", 0)

        val locationValue = sharedPreferencesLocation!!.getInt("type", 0)
        editorLocation = sharedPreferencesLocation!!.edit()

        if (locationValue == 1) {
            binding.toggeMap!!.setChecked(true)
        } else if (locationValue == 2) {
            binding.toggelGps!!.setChecked(true)
        }


    }
    fun locationClicked(view: View?) {

        if ( binding.toggeMap!!.isChecked) {
            editorLocation!!.putInt("type", 1)
            val intent= Intent(this, Map2::class.java)
            startActivity(intent)

        } else if ( binding.toggelGps!!.isChecked) {
            editorLocation!!.putInt("type", 2)
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Save the changes
        editorLocation!!.commit()
    }


// TemperatureClicked
//,c,k,f

    fun chooseTemperature(){


        tempsharedPreferences = getSharedPreferences("temp", 0)

        val unitesValue = tempsharedPreferences!!.getInt("temp", 0)
        editortemp = tempsharedPreferences!!.edit()

        if (unitesValue == 1) {
            binding.toggeDegreeCelsiuss!!.setChecked(true)
        } else if (unitesValue == 2) {
            binding.toggelKelvinn!!.setChecked(true)
        }
        else if (unitesValue == 3) {
            binding.toggelFahrenheitt!!.setChecked(true)
        }

    }




    fun TemperatureClicked(view: View?) {

        if ( binding.toggeDegreeCelsiuss!!.isChecked) {
            editortemp!!.putInt("temp", 1)
        } else if ( binding.toggelKelvinn!!.isChecked) {
            editortemp!!.putInt("temp", 2)

        }
        else if (binding.toggelFahrenheitt!!.isChecked) {
            editortemp!!.putInt("temp", 3)

        }
        // Save the changes
        editortemp!!.commit()
    }

//windClicked


    fun choosewindSpeed(){


        sharedPreferencesSpeed = getSharedPreferences("Speed", 0)

        val speedValue = sharedPreferencesSpeed!!.getInt("Speed", 0)
        editorSpeed = sharedPreferencesSpeed!!.edit()

        if (speedValue == 1) {
            binding.toggeMs!!.setChecked(true)
        } else if (speedValue == 2) {
            binding.toggelMh!!.setChecked(true)
        }


    }
    fun windClicked(view: View?) {

        if ( binding.toggeMs!!.isChecked) {
            editorSpeed!!.putInt("Speed", 1)

        } else if ( binding.toggelMh!!.isChecked) {
            editorSpeed!!.putInt("Speed", 2)

        }

        // Save the changes
        editorSpeed!!.commit()
    }


//
    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this, MainActivity::class.java)
       startActivity(intent)
        finish()



    }
}
