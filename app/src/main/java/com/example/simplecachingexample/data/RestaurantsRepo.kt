package com.example.simplecachingexample.data

import android.util.Log
import androidx.room.withTransaction
import com.example.monitoringanetworkconnectioninrealtimewithlivedata.TAG
import com.example.simplecachingexample.api.ApiService
import com.example.simplecachingexample.data.mapper.Restaurants
import com.example.simplecachingexample.data.mapper.RestaurantsMapper
import com.example.simplecachingexample.data.model.RestaurantModel
import com.example.simplecachingexample.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RestaurantsRepo @Inject constructor(
    private val api: ApiService,
    private val db: RestaurantsDatabase
) {

    private val restaurantDao = db.restaurantsDao
    private val mapper = RestaurantsMapper()

    fun getAllRestaurantsFromDB() = restaurantDao.getAllRestaurants()

    suspend fun getAllRestaurantsFromAPI(): Flow<Resource<List<Restaurants>>> {
        return flow {
            emit(Resource.loading(null))
            try {
                val results = api.getRestaurants()

                if (results.isSuccessful) {
                    val restaurants = results.body()?.map {
                        mapper.map(it)
                    }

                    Log.i(TAG, "getAllRestaurantsFromAPI repooo: $restaurants")
                    db.withTransaction {
                        restaurantDao.deleteAllRestaurants()
                        if (restaurants != null) {
                            restaurantDao.insertAllRestaurants(restaurants)
                        }
                    }
                    emit(Resource.success(restaurants))
                }else{
                    Log.i(TAG, "getAllRestaurantsFromAPI repooo error: ${results.message()}")
                    emit(Resource.error(results.message() , null))
                }

            } catch (e: Exception) {
                Log.i(TAG, "getAllRestaurantsFromAPI Exception: ${e.localizedMessage}")

                emit(Resource.error(e.localizedMessage , null))
            }

        }
    }
    //
    //    {
//        try {
//            val results = api.getRestaurants()
//
//            if (results.isSuccessful) {
//               val restaurants =  results.body()?.map {
//                    mapper.map(it)
//                }
//
//                db.withTransaction {
//                    restaurantDao.deleteAllRestaurants()
//                    if (restaurants != null) {
//                        restaurantDao.insertAllRestaurants(restaurants)
//                    }
//                    return@withTransaction restaurants
//            }
//
//            }
//
//        }catch (e : Exception){
//
//        }
//        return null
//    }


//    fun getRestaurants() = networkBoundResource(
//        query = {
//            restaurantDao.getAllRestaurants()
//        },
//        fetch = {
//            delay(2000)
//            api.getRestaurants()
//        },
//        saveFetchResult = { restaurants ->
//            db.withTransaction {
//               restaurantDao.deleteAllRestaurants()
//                 restaurants.body()?.let { restaurantDao.insertAllRestaurants(it) }
//            }
//        }
//    )


}