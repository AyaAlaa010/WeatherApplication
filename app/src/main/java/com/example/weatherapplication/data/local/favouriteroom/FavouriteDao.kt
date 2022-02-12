package com.example.weatherapplication.data.local.favouriteroom

import androidx.room.*

@Dao
interface FavouriteDao {

    @Insert
    fun addLocation(favEntity: FavouriteEntity)

    @Delete
    fun deleteLocation(favEntity: FavouriteEntity)

    @Update
    fun updateLocation(favEntity: FavouriteEntity)

    @Query("SELECT * FROM favourite")
    fun getFavouriteLocation(): List<FavouriteEntity>

    @Query("DELETE FROM favourite")
    fun deleteAll()

}