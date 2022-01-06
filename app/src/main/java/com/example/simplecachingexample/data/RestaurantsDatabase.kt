package com.example.simplecachingexample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplecachingexample.data.mapper.Restaurants
import com.example.simplecachingexample.data.model.RestaurantModel

@Database(entities = [Restaurants::class], version = 1)
abstract class RestaurantsDatabase : RoomDatabase() {
    abstract val restaurantsDao: RestaurantsDao


}