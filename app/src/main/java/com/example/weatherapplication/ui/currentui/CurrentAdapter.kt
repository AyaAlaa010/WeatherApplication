package com.example.weatherapplication.ui.currentui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.Daily
import com.example.example.Hourly
import com.example.weatherapplication.R
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.databinding.ItemCurrentHoursBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CurrentAdapter(val currentHourList: ArrayList<Hourly>, val context: Context) :
    RecyclerView.Adapter<CurrentAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_current_hours,
                parent,
                false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hourly: Hourly = currentHourList.get(position)
        var link = "http://openweathermap.org/img/wn/" + (hourly.weather.get(0).icon) + "@2x.png"
        Glide.with(context).load(link).into(holder.itemBinding.itemImgHour)
       // holder.itemBinding.itemDegreeHour.setText(hourly.temp.toString())
//
        if (StreetDateClass(holder.itemBinding.itemDegreeHour.context).setTemperature() == 1) {//c
            // K - 273.15
            val degree= hourly.temp?.minus(273.15)
            val number:Double=String.format("%.2f", degree).toDouble()

            holder.itemBinding.itemDegreeHour.setText(number.toString() + " C")


        } else if (StreetDateClass(holder.itemBinding.itemDegreeHour.context).setTemperature() == 2) {//k
            val number:Double=String.format("%.2f", hourly.temp).toDouble()

            holder.itemBinding.itemDegreeHour.setText( number.toString() + " K")


        } else if (StreetDateClass(holder.itemBinding.itemDegreeHour.context).setTemperature() == 3) {//f

            //°F = (K − 273.15) × 9/5 + 32
            val degree=(((hourly.temp)?.minus(273.15))?.times(9/3)?.plus(32))
            val number:Double=String.format("%.2f", degree).toDouble()

            holder.itemBinding.itemDegreeHour.setText( number.toString() + " F")


        }

        //unites







//hour format
        try {
            val sdf = SimpleDateFormat("hh")
            val netDate = Date(((hourly.dt).toString()).toLong() * 1000)
            Log.i("hour", "observeViewModel: "+sdf.format(netDate))
            holder.itemBinding.itemHourCurrent.text = sdf.format(netDate)

        } catch (e: Exception) {
            Log.i("error", "observeViewModel: "+ e.toString())
        }


    }

    override fun getItemCount(): Int {
       return currentHourList.size
    }


    class ViewHolder(itemBinding: ItemCurrentHoursBinding) :
        RecyclerView.ViewHolder(itemBinding.getRoot()) {
        var itemBinding: ItemCurrentHoursBinding

        init {
            this.itemBinding = itemBinding
        }
    }

}