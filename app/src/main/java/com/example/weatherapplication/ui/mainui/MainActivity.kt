package com.example.weatherapplication.ui.mainui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.weatherapplication.R
import com.example.weatherapplication.constant.ERROR_DIALOG_REQUEST
import com.example.weatherapplication.constant.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
import com.example.weatherapplication.constant.PERMISSIONS_REQUEST_ENABLE_GPS
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.ui.pagerview.PagerAdapter
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

// EasyPermissions.PermissionCallbacks
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //****************
    lateinit var binding: ActivityMainBinding
    lateinit var actionBarTogel: ActionBarDrawerToggle
    lateinit var pagerAdapter: PagerAdapter
    val TAG="MainActivity"
    private var mLocationPermissionGranted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadLocate()

        languageDialog()
        handelNavigation()

        handelViewPagerwithTap()

        binding.navView.setNavigationItemSelectedListener(this)
    }

    fun languageDialog(){


        val sharedPreferences: SharedPreferences = getSharedPreferences("weather", Context.MODE_PRIVATE)
        var first :Boolean=sharedPreferences.getBoolean("first",true)
        if(first){

            AlertDialog.Builder(this).setMessage(getString(R.string.favourite_message))
                .setMessage(getString(R.string.chooselanguageDialog))
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    showChangeLang()

                }.show()

        }

        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("first",false)
        editor.apply()
        editor.commit()




    }


    fun handelNavigation() {

        actionBarTogel = ActionBarDrawerToggle(this, binding.myDrawerLayout2, R.string.nav_open, R.string.nav_close)
        binding.myDrawerLayout2.addDrawerListener(actionBarTogel)
        actionBarTogel.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarTogel.onOptionsItemSelected(item)) {
            true

        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.alert -> {


            }
            R.id.settings -> {
                val intent = Intent(this, Settings::class.java)
                startActivity(intent)
                finish()
            }

            R.id.languages -> {

                showChangeLang()


            }


        }
        binding.myDrawerLayout2.closeDrawer(GravityCompat.START)
        return true
    }
    ///




    private fun showChangeLang() {

        val listItmes = arrayOf("عربي",  "English")

        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle(getString(R.string.chooselanguage))
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            if (which == 0) {
                setLocate("ar")
                recreate()
            } else if (which == 1) {
                setLocate("en")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()

    }

    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        setLocate(language!!)
    }

////
    fun handelViewPagerwithTap() {

        pagerAdapter = PagerAdapter(this)
        binding.viewPager2.adapter = pagerAdapter
        //connect tab with view pager
        var mediator: TabLayoutMediator = TabLayoutMediator(binding.tabLayout,
            binding.viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {

                    0 -> tab.setText(getString(R.string.currentday))
                    1 -> tab.setText(getString(R.string.nextday))
                    2 -> tab.setText(getString(R.string.favourite))

                    else -> tab.setText(getString(R.string.currentday))
                }
            })

        mediator.attach()


    }

//background permissions
    private fun checkMapServices(): Boolean {
        if (isServicesOK()) {
            if (isMapsEnabled()) {
                return true
            }
        }
        return false
    }

    private fun buildAlertMessageNoGps() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.gps_message))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.yes)) { dialog, id ->
                val enableGpsIntent =
                    Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivityForResult(enableGpsIntent, PERMISSIONS_REQUEST_ENABLE_GPS)
            }
        val alert = builder.create()
        alert.show()
    }


    fun isMapsEnabled(): Boolean {
        val manager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps()
            return false
        }
        return true
    }


    private fun getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            mLocationPermissionGranted = true
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION)
        }
    }


    fun isServicesOK(): Boolean {
        Log.d("TAG", "isServicesOK: checking google services version")
        val available =
            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this@MainActivity)
        if (available == ConnectionResult.SUCCESS) {
            //everything is fine and the user can make map requests
            Log.d("TAG", "isServicesOK: Google Play Services is working")
            return true
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //an error occured but we can resolve it
            Log.d("TAG", "isServicesOK: an error occured but we can fix it")
            val dialog = GoogleApiAvailability.getInstance()
                .getErrorDialog(this@MainActivity, available, ERROR_DIALOG_REQUEST)
            dialog.show()
        } else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show()
        }
        return false
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray, ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        mLocationPermissionGranted = false
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION -> {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TAG", "onActivityResult: called.")
        when (requestCode) {
            PERMISSIONS_REQUEST_ENABLE_GPS -> {
                if (mLocationPermissionGranted) {
                } else {
                    getLocationPermission()
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        if (checkMapServices()) {
            if (mLocationPermissionGranted) {
            } else {
                getLocationPermission()
            }
        }
    }



}






