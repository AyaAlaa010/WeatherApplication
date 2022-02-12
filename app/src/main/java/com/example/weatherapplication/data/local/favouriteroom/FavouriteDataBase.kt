package com.example.weatherapplication.data.local.favouriteroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavouriteEntity::class], version = 1, exportSchema = false)

  abstract class FavouriteDataBase : RoomDatabase() {

    abstract fun favouriteDao(): FavouriteDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FavouriteDataBase? = null

        fun getInstance(context: Context): FavouriteDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteDataBase::class.java,
                    "favourite_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}