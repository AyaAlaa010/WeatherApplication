package com.example.weatherapplication.data.local.current

import androidx.room.*
import com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity

@Dao
interface CurrentDao {

    @Insert
    fun addLocation(currentEntity: CurrentEntity)

    @Query("SELECT * FROM myCurrent")
    fun getCurrentLocation(): List<CurrentEntity>

    @Update
    fun updateCurrentLocation(currentEntity: CurrentEntity)

    @Query("DELETE FROM myCurrent")
    fun deleteAll()



}