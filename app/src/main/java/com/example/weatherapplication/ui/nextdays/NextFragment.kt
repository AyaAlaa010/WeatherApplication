package com.example.weatherapplication.ui.nextdays

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.R
import com.example.weatherapplication.data.publicmethods.StreetDateClass
import com.example.weatherapplication.databinding.FragmentNextBinding
import com.example.weatherapplication.ui.currentui.CurrentFragment
import com.example.weatherapplication.ui.mainui.Settings
import com.example.weatherapplication.viewmodels.DailyViewModel


class NextFragment : Fragment() {
lateinit var fragmentNextBinding: FragmentNextBinding
lateinit var  dailyViewModel: DailyViewModel
lateinit var nextAdapter: NextAdapter
    var liveData2 = MutableLiveData<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        activity?.let {
            dailyViewModel = ViewModelProvider(it).get(DailyViewModel::class.java)
        }

        fragmentNextBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_next, container, false)


        return fragmentNextBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var storedLocation=   StreetDateClass(requireContext()).getLocation()
        var splitItems=storedLocation.split("+")

        initViews(splitItems.get(0).toDouble(), splitItems.get(1).toDouble(), "minutely,hourly", "en",
           "standard")
        dailyobserveViewModel()
    }
    private fun initViews(lat: Double, lon: Double, exclude: String, lang: String, units: String) {
        dailyViewModel.getWeather(lat,
            lon,
            exclude,
            lang,
            units)
    }


    fun dailyobserveViewModel(){

        dailyViewModel.weatherLiveData.observe(viewLifecycleOwner, Observer {

//
            Log.i("TAGsssssssssss", "onCreateView: " + it.daily.size)


           val address= StreetDateClass(requireContext()).getStreetName(it.lat!!,it.lon!!)


            fragmentNextBinding.currentAddressDays.text=address
            var currentHourListt = it.daily


            nextAdapter = NextAdapter(currentHourListt, requireContext())
            val layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

            fragmentNextBinding.recNext.adapter = nextAdapter
            fragmentNextBinding.recNext.layoutManager = layoutManager



        })

}}