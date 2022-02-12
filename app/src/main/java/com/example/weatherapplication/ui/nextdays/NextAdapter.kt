package com.example.weatherapplication.ui.nextdays

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.Daily
import com.example.example.Hourly
import com.example.weatherapplication.R
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.databinding.ItemCurrentHoursBinding
import com.example.weatherapplication.databinding.ItemNextBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class NextAdapter(val currentDailyList: ArrayList<Daily>, val context: Context) :
    RecyclerView.Adapter<NextAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_next,
                parent,
                false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val daily: Daily = currentDailyList.get(position)
        //holder.itemBinding.TestModel(product)
       Log.i("ggggggggggggggggggggnn", "onBindViewHolder: "+daily.temp.toString())
       var link =
            "http://openweathermap.org/img/wn/" + (daily.weather.get(0).icon) + "@2x.png"

        Glide.with(context).load(link).into(holder.itemBinding.imgIcon)
        //

        holder.itemBinding.currentPressure.setText("pressure: "+daily.pressure?.toString())
        holder.itemBinding.currentClouds.setText("clouds: "+daily.clouds?.toString()+"%")
        holder.itemBinding.currentHumedity.setText("humidity : "+daily.humidity?.toString()+"%")
        holder.itemBinding.statusCurrent.setText(daily.weather.get(0).description.toString())
        holder.itemBinding.nextDate.text= getDateTime( daily.dt.toString())

//


        if (StreetDateClass(holder.itemBinding.currentClouds.context).setTemperature() == 1) {//c
            // K - 273.15
            val degreemin=daily.temp?.min?.minus(273.15)
           val degreemax=daily.temp?.max?.minus(273.15)
            holder.itemBinding.currentTempMin.setText(degreemin?.toFloat().toString() + " C")

            holder.itemBinding.currentTempMax.setText(degreemax?.toFloat().toString()+" C")


        } else if (StreetDateClass(holder.itemBinding.currentClouds.context).setTemperature() == 2) {//k


            holder.itemBinding.currentTempMin.setText(daily.temp?.min.toString() + " K")

            holder.itemBinding.currentTempMax.setText(daily.temp?.max.toString()+" K")

        } else if (StreetDateClass(holder.itemBinding.currentClouds.context).setTemperature() == 3) {//f

            //°F = (K − 273.15) × 9/5 + 32
            val degreemin=(((daily.temp?.min)?.minus(273.15))?.times(9/3)?.plus(32))

            val degreemax=(((daily.temp?.max)?.minus(273.15))?.times(9/3)?.plus(32))

            holder.itemBinding.currentTempMin.setText(degreemin?.toFloat().toString() + " F")

            holder.itemBinding.currentTempMax.setText(degreemax?.toFloat().toString()+" F")


        }


        if (StreetDateClass(holder.itemBinding.currentClouds.context).setWindSpeed() == 1) {//c
            // mile= sec*2.236936
            val number:Double=String.format("%.2f",daily.windSpeed).toDouble()

            holder.itemBinding.currentWind.setText("wind: "+number.toString()+" m/s")




        } else if (StreetDateClass(holder.itemBinding.currentClouds.context).setWindSpeed() == 2) {//k

            val degree= daily.windSpeed?.times(2.236936)
            val number:Double=String.format("%.2f",degree).toDouble()
            holder.itemBinding.currentWind.setText("wind : "+number.toString()+" m/h")


        }





//        //
//        if(StreetDateClass(holder.itemBinding.imgIcon.context).setUnites().equals("standard")) {
//            holder.itemBinding.currentWind.setText("wind: "+daily.windSpeed?.toString()+" m/s ")
       // holder.itemBinding.currentTempMin.setText(daily.temp?.min.toString()+" C")
       // holder.itemBinding.currentTempMax.setText(daily.temp?.max.toString()+" C")
//
//        }
//        else if(StreetDateClass(holder.itemBinding.imgIcon.context).setUnites().equals("metric")) {
//            holder.itemBinding.currentWind.setText("wind: "+daily.windSpeed?.toString()+" m/s ")
    //    holder.itemBinding.currentTempMin.setText(daily.temp?.min.toString()+" K")
     //   holder.itemBinding.currentTempMax.setText(daily.temp?.max.toString()+" K")
//        }
//        else if(StreetDateClass(holder.itemBinding.imgIcon.context).setUnites().equals("imperial")) {
//            holder.itemBinding.currentWind.setText("wind: "+daily.windSpeed?.toString()+" m/h ")
       // holder.itemBinding.currentTempMin.setText(daily.temp?.min.toString()+" F")
      //  holder.itemBinding.currentTempMax.setText(daily.temp?.max.toString()+" F")
//
//
//        }



   //
    }

    override fun getItemCount(): Int {
        return currentDailyList.size
    }


    private fun getDateTime(s: String): String? {
        //dd/MM/yyyy hh:mm:ss
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date((s).toLong() * 1000)
            return sdf.format(netDate)

        } catch (e: Exception) {
            return e.toString()
        }


    }


    class ViewHolder(itemBinding: ItemNextBinding) :
        RecyclerView.ViewHolder(itemBinding.getRoot()) {
        var itemBinding: ItemNextBinding

        init {
            this.itemBinding = itemBinding
        }
    }

}