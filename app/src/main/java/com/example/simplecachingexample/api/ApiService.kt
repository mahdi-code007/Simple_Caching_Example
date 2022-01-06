package com.example.simplecachingexample.api

import com.example.simplecachingexample.data.model.RestaurantModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("restaurant/random_restaurant?size=100")
    suspend fun getRestaurants() : Response<List<RestaurantModel>>

//    @GET("restaurant/random_restaurant?size=5")
//    suspend fun getRestaurants() : List<RestaurantModel>
}