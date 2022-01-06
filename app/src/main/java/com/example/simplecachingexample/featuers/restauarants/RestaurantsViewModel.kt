package com.example.simplecachingexample.featuers.restauarants

import android.util.Log
import androidx.lifecycle.*
import com.example.monitoringanetworkconnectioninrealtimewithlivedata.TAG
import com.example.simplecachingexample.api.ApiService
import com.example.simplecachingexample.data.RestaurantsRepo
import com.example.simplecachingexample.data.mapper.Restaurants
import com.example.simplecachingexample.data.model.RestaurantModel
import com.example.simplecachingexample.utils.Resource
import com.example.simplecachingexample.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
//    api: ApiService
    private val repository: RestaurantsRepo
) : ViewModel(), LifecycleObserver {

//    val restaurants = repository.getRestaurants().asLiveData()


    private val _result = MutableLiveData<Resource<List<Restaurants>>>()
    val result: LiveData<Resource<List<Restaurants>>> get() = _result


    fun getAllRestaurantsFromDB() {
        viewModelScope.launch {
            _result.postValue(Resource.loading(null))
            val restaurants = repository.getAllRestaurantsFromDB()
            restaurants.collect() {
                if (!it.isNullOrEmpty()) {
                    _result.postValue(Resource.success(it))
                } else {
                    _result.postValue(Resource.error("Database is empty", null))
                }
            }

        }
    }


    fun getAllRestaurantsFromAPIAndSaveThem() {
        viewModelScope.launch {
//            _result.postValue(Resource.loading(null))
            repository.getAllRestaurantsFromAPI()
                .collect() { restaurants ->
                getAllRestaurantsFromDB()
                Log.i(TAG, "getAllRestaurantsFromAPIAndSaveThem ViewModel: $restaurants")
                if (!restaurants.data.isNullOrEmpty()) {
//                    _result.postValue(Resource.success(restaurants.data))
                } else {
//                    _result.postValue(restaurants.message?.let { Resource.error(it, null) })
                }
            }


        }
    }
}

//    fun getRestaurants() {
//        viewModelScope.launch(IO) {
//            val restaurants = repository.getRestaurants()
////            _result.postValue(Resource.Loading(null))
//            restaurants.collect {
//
//                Log.i(TAG, "getRestaurants: ${it.data}")
//                Log.i(TAG, "getRestaurants: ${it.error?.localizedMessage}")
//                if (!it.data.isNullOrEmpty()) {
//                    _result.postValue(Resource.Success(it.data))
//                } else {
////                    _result.postValue(it.error?.let { it1 -> Resource.Error(it1) })
//                }
//            }
//
//        }
//    }


