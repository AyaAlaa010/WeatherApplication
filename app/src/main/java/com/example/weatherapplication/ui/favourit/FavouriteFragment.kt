package com.exam

import android.app.Activity.RESULT_OK
import com.example.weatherapplication.ui.favourit.FavouriteAdapter


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.databinding.FragmentFavouriteBinding
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.weatherapplication.R
import com.example.weatherapplication.data.local.favouriteroom.FavouriteDataBase
import com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.internetconnection.InternetHandeling
import com.example.weatherapplication.ui.maps.MapActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability


class FavouriteFragment : Fragment(), View.OnClickListener {
    lateinit var fragmentFavouriteBinding: FragmentFavouriteBinding
    var favouritArray: ArrayList<FavouriteEntity> = ArrayList()
    lateinit var favouriteAdapter: FavouriteAdapter
    private val ERROR_DIALOG_REQUEST = 9001
    val TAG = "Favourit fragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        fragmentFavouriteBinding = DataBindingUtil.inflate(inflater, com.example.weatherapplication.R.layout.fragment_favourite, container, false)
        return fragmentFavouriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if (InternetHandeling.checkForInternet(requireContext())) {

            fragmentFavouriteBinding.floatingActionButton.setOnClickListener(this);
            Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
            favouritArray = FavouriteDataBase.getInstance(requireContext()).favouriteDao().getFavouriteLocation() as ArrayList<FavouriteEntity>
            favouriteAdapter = FavouriteAdapter(favouritArray, requireContext())
            val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            fragmentFavouriteBinding.recFavourite.adapter = favouriteAdapter
            fragmentFavouriteBinding.recFavourite.layoutManager = layoutManager
        } else {
            Toast.makeText(requireContext(), "Disconnected", Toast.LENGTH_SHORT).show()
            favouritArray = FavouriteDataBase.getInstance(requireContext()).favouriteDao().getFavouriteLocation() as ArrayList<FavouriteEntity>
            favouriteAdapter = FavouriteAdapter(favouritArray, requireContext())
            val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            fragmentFavouriteBinding.recFavourite.adapter = favouriteAdapter
            fragmentFavouriteBinding.recFavourite.layoutManager = layoutManager
        }
    }

    fun isServicesOK(): Boolean {
        Log.d(TAG, "isServicesOK: checking google services version")
        val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireContext())
        if (available == ConnectionResult.SUCCESS) {
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working")
            return true
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it")
            val dialog = GoogleApiAvailability.getInstance()
                .getErrorDialog(this, available, ERROR_DIALOG_REQUEST)
            dialog!!.show()
        } else {
            Toast.makeText(requireContext(), "You can't make map requests", Toast.LENGTH_SHORT)
                .show()
        }
        return false
    }


    override fun onClick(view: View?) {
        if (view?.id == com.example.weatherapplication.R.id.floating_action_button) {

            if (InternetHandeling.checkForInternet(requireContext())) {
                Toast.makeText(requireContext(), "Connected", Toast.LENGTH_SHORT).show()
                if (StreetDateClass(requireContext()).mapDifferentActivity() == 2) {
                    if (isServicesOK()) {
                        val intent = Intent(requireContext(), MapActivity::class.java)
                        startActivityForResult(intent, 101)

                    }
                }
                //edite setting to be gps
                else {

                    AlertDialog.Builder(requireContext())
                        .setMessage(getString(R.string.favourite_message))
                        .setNegativeButton(getString(R.string.Cancel), null)
                        .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                            val intent = Intent(requireContext(),
                                com.example.weatherapplication.ui.mainui.Settings::class.java)
                            startActivity(intent)
                            activity?.finish()

                        }.show()
                }
            } else {
                Toast.makeText(requireContext(),
                    "Disconnected,please connect to a network then try agin",
                    Toast.LENGTH_LONG).show()
                AlertDialog.Builder(requireContext()).setMessage(getString(R.string.networkmessage))
                    .setNegativeButton(getString(R.string.Cancel), null)
                    .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                        dialog.dismiss()

                    }.show()
            }

        }


    }

    // for notify
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK) {


            favouritArray = FavouriteDataBase.getInstance(requireContext()).favouriteDao().getFavouriteLocation() as ArrayList<FavouriteEntity>
            favouriteAdapter = FavouriteAdapter(favouritArray, requireContext())
            fragmentFavouriteBinding.recFavourite.adapter = favouriteAdapter
        }
    }
}







