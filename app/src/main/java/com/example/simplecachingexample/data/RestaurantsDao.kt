package com.example.simplecachingexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplecachingexample.data.mapper.Restaurants
import com.example.simplecachingexample.data.model.RestaurantModel
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantsDao {

    @Query("SELECT * FROM restaurants_table")
    fun getAllRestaurants() : Flow<List<Restaurants>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRestaurants(restaurants : List<Restaurants>)

    @Query("DELETE FROM restaurants_table")
    suspend fun deleteAllRestaurants()
}