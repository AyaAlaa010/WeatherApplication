package com.example.weatherapplication.data.local.current

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "myCurrent")
class CurrentEntity() {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int=0


    @ColumnInfo(name="key")
    var key:Int=0



    //



    @ColumnInfo(name="currentAddress")
    lateinit var currentAddress : String

    @ColumnInfo(name="currentDate")
    lateinit var currentDate : String


    //

    @ColumnInfo(name="currentDescription")
   lateinit var currentDescription : String

    @ColumnInfo(name="currentTemp")
    lateinit var currentTemp : String


    @ColumnInfo(name="currentPressure")
    var currentPressure : Int=0

    @ColumnInfo(name="currentHumedity")
    var currentHumedity : Int=0

    @ColumnInfo(name="currentWind")
    lateinit var currentWind : String

    @ColumnInfo(name="currentCloud")
    var currentCloud : Int=0

    @ColumnInfo(name="currentIcon")
    lateinit var currentIcon : String








}