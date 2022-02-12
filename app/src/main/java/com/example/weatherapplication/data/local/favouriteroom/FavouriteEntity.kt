package com.example.weatherapplication.data.local.favouriteroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favourite")
class FavouriteEntity( favouriteLatLon : String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int=0

    @ColumnInfo(name="favouriteLatLon")
    var favouriteLatLon : String =favouriteLatLon











}