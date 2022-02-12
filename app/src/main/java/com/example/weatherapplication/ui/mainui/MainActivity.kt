package com.example.weatherapplication.ui.mainui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.exam.FavouriteFragment
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.ActivityMainBinding
import com.example.weatherapplication.ui.maps.Map2
import com.example.weatherapplication.ui.pagerview.PagerAdapter
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

// EasyPermissions.PermissionCallbacks
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //****************
    lateinit var binding: ActivityMainBinding
    lateinit var actionBarTogel: ActionBarDrawerToggle
    lateinit var pagerAdapter: PagerAdapter
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    val TAG="MainActivity"
    private val ERROR_DIALOG_REQUEST = 9002

//    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)//******
//     //   fetchLocation()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        handelNavigation()

        handelViewPagerwithTap()

        binding.navView.setNavigationItemSelectedListener(this)



    }


    fun handelNavigation() {

        actionBarTogel = ActionBarDrawerToggle(this, binding.myDrawerLayout2,
            R.string.nav_open,
            R.string.nav_close)
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
                //toast("nav_home menu item is selected")

                Log.i("hh", "onNavigationItemSelected: " + "alert")

            }
            R.id.settings -> {
                Log.i("hh", "onNavigationItemSelected: " + "settings")
                val intent = Intent(this, Settings::class.java)
                startActivity(intent)
                finish()
            }
        }
        binding.myDrawerLayout2.closeDrawer(GravityCompat.START)
        return true
    }








    //





    fun handelViewPagerwithTap() {

        pagerAdapter = PagerAdapter(this)
        binding.viewPager2.adapter = pagerAdapter
        //connect tab with view pager
        var mediator: TabLayoutMediator = TabLayoutMediator(binding.tabLayout,
            binding.viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {

                    0 -> tab.setText("Current Day")
                    1 -> tab.setText("Next Days ")
                    2 -> tab.setText("Favourite ")

                    else -> tab.setText("Current Day")
                }
            })

        mediator.attach()


    }



}






