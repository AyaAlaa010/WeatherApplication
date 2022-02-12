package com.example.weatherapplication.ui.favourit

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.databinding.ItemFavouriteBinding
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.data.local.favouriteroom.FavouriteDataBase
import com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.ui.maps.Map2


class FavouriteAdapter(val favouritArray: ArrayList<FavouriteEntity>, val context: Context) :
    RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    val TAG="Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                com.example.weatherapplication.R.layout.item_favourite,
                parent,
                false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favModel:FavouriteEntity= favouritArray.get(position)
        Log.i("ttttttttttttttttttttttt", "onBindViewHolder: "+favouritArray.size)



        var addressroom=favModel.favouriteLatLon.split("+")
        var addressConvert=StreetDateClass(holder.itemBinding.mymenue.context).getStreetName(addressroom.get(0).toDouble(),addressroom.get(1).toDouble())
               holder.itemBinding.tvFavLocation.setText(addressConvert)
                holder.itemView.setOnClickListener{
                    val intent= Intent(context,FavouriteLocationDetails::class.java)
                    intent.putExtra("details",favModel.favouriteLatLon)
                    context.startActivity(intent)



                }

        holder.itemBinding.mymenue.setOnClickListener{

            AlertDialog.Builder(it.getContext()).setMessage("are you sure to delete this location ?")
                .setNegativeButton("cancle", null)
                .setPositiveButton("delete") { dialog, which ->

                    FavouriteDataBase.getInstance(holder.itemBinding.mymenue.context).favouriteDao().deleteLocation(favModel)
                    favouritArray.removeAt(position)
                    notifyDataSetChanged()
                }.show()


        }




    }

    override fun getItemCount(): Int {
        return favouritArray.size
    }






    class ViewHolder(itemBinding: ItemFavouriteBinding) :
        RecyclerView.ViewHolder(itemBinding.getRoot()) {
        var itemBinding: ItemFavouriteBinding

        init {
            this.itemBinding = itemBinding
        }
    }


}