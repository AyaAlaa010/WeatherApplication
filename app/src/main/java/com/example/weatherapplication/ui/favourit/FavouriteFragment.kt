package com .exam

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
import com.example.weatherapplication.data.local.favouriteroom.FavouriteDataBase
import com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity
import com.example.weatherapplication.ui.maps.Map2
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability


class FavouriteFragment : Fragment() ,View.OnClickListener{
lateinit var fragmentFavouriteBinding: FragmentFavouriteBinding

 var favouritArray: ArrayList<FavouriteEntity> = ArrayList()
lateinit var favouriteAdapter: FavouriteAdapter
    private val ERROR_DIALOG_REQUEST = 9001
    val TAG="Favourit fragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        fragmentFavouriteBinding = DataBindingUtil.inflate(inflater, com.example.weatherapplication.R.layout.fragment_favourite, container, false)

        fragmentFavouriteBinding.floatingActionButton.setOnClickListener(this);
        return fragmentFavouriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//
//        if(arguments!=null){
//
//            model= arguments?.getSerializable("model") as FavouritModel
//            Log.i(TAG, "openFragment: new "+ model.latitude+"xxnnnnnnnnn"+model.langitude)
//            favouritArray.value=model
//
//
//
//
//        }
favouritArray= FavouriteDataBase.getInstance(requireContext()).favouriteDao().getFavouriteLocation() as ArrayList<FavouriteEntity>


        favouriteAdapter = FavouriteAdapter(favouritArray , requireContext())
        val layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        fragmentFavouriteBinding.recFavourite.adapter = favouriteAdapter
        fragmentFavouriteBinding.recFavourite.layoutManager = layoutManager

    }
    fun isServicesOK(): Boolean {
        Log.d(TAG, "isServicesOK: checking google services version")
        val available =
            GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireContext())
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
            Toast.makeText(requireContext(), "You can't make map requests", Toast.LENGTH_SHORT).show()
        }
        return false
    }


    override fun onClick(view: View?) {
        if(view?.id  == com.example.weatherapplication.R.id.floating_action_button) {
            Toast.makeText(requireContext(), "item added", Toast.LENGTH_SHORT).show()
            if(isServicesOK()){

                val intent = Intent(requireContext(), Map2::class.java)
                startActivityForResult(intent,101)


            }
        }
        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101 &&resultCode==RESULT_OK){



            favouritArray= FavouriteDataBase.getInstance(requireContext()).favouriteDao().getFavouriteLocation() as ArrayList<FavouriteEntity>

            favouriteAdapter= FavouriteAdapter(favouritArray , requireContext())
            fragmentFavouriteBinding.recFavourite.adapter = favouriteAdapter

        }



    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//if(resultCode==1){
//
//if(resultCode == RESULT_OK){
//
//model= data?.getSerializableExtra("modfav") as FavouritModel
//    Log.i("araffffffff", "onActivityResult:cccccc "+model.langitude +model.langitude)
//
//    favouritArray.add(model)
//
//}



//}

    //}



//  val inter:   InterfaceFvourite= object : InterfaceFvourite {
//      override fun openFragment() {
//
//          activity?.getSupportFragmentManager()
//              ?.beginTransaction()
//              ?.replace(com.example.weatherapplication.R.id.fram_fav_detals, FavouriteDetailsFragment())
//              ?.commit()
//      }
  }







