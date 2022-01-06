package com.example.simplecachingexample.featuers.restauarants

import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monitoringanetworkconnectioninrealtimewithlivedata.ConnectionLiveData
import com.example.monitoringanetworkconnectioninrealtimewithlivedata.TAG
import com.example.simplecachingexample.R
import com.example.simplecachingexample.databinding.ActivityRestaurantsBinding
import com.example.simplecachingexample.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantsActivity : AppCompatActivity() {

    private val viewModel: RestaurantsViewModel by viewModels()
    private lateinit var binding: ActivityRestaurantsBinding
    private lateinit var restaurantsAdapter: RestaurantsAdapter
    private lateinit var connectionLiveData: ConnectionLiveData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurants)

        setupUi()
        setupObserver()

    }

    private fun setupUi() {

        connectionLiveData = ConnectionLiveData(this)

        restaurantsAdapter = RestaurantsAdapter()
        binding.restaurantsRv.apply {
            layoutManager = LinearLayoutManager(this@RestaurantsActivity)
            this.adapter = restaurantsAdapter
        }

        viewModel.getAllRestaurantsFromDB()

    }

    private fun setupObserver() {


        connectionLiveData.observe(this, Observer {
            if (it) {
                viewModel.getAllRestaurantsFromAPIAndSaveThem()
                binding.loadingLl.visibility = View.GONE
                binding.state.visibility = View.VISIBLE
                binding.state.text = "Online Mode"
                binding.state.setBackgroundResource(R.color.green)
            }else{
                viewModel.getAllRestaurantsFromDB()
                binding.state.visibility = View.VISIBLE
                binding.loadingLl.visibility = View.GONE
                binding.state.text = "Offline Mode"
                binding.state.setBackgroundResource(R.color.red)

            }

        })

//        viewModel.result.observe(this, Observer { result ->
//            Log.i(TAG, "setupObserver: ${result.data}")
//
//            restaurantsAdapter.differ.submitList(result.data)
//
//            binding.loadingLl.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
//            binding.textView.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
//            binding.textView.text = result.error?.localizedMessage
//        })


        viewModel.result.observe(this) { restaurants ->
            when (restaurants.status) {
                Status.SUCCESS -> {
                    binding.loadingLl.visibility = View.GONE
                    binding.textView.visibility = View.GONE
                    Toast.makeText(this, "Data Loaded ..", Toast.LENGTH_SHORT).show()
                    Log.i("ScanningActivity", "setupObserver: ${restaurants.data}")
                    restaurantsAdapter.differ.submitList(restaurants.data)
                }
                Status.ERROR -> {
                    binding.loadingLl.visibility = View.GONE
                    binding.textView.visibility = View.VISIBLE
                    binding.textView.text = "Sorry No Data Cached ! \n No internet connection"
                    Log.i("ScanningActivity", "--- ERROR ${restaurants.message}")
                }
                Status.LOADING -> {
                    binding.loadingLl.visibility = View.VISIBLE
                    Log.i("ScanningActivity", "--- LOADING CART")
                }

            }
        }
    }


}


//private fun setValueAnimatorEffect() {
//        ValueAnimator.ofInt(0, 10000).apply {
//            duration = 1500
//            start()
//
//            addUpdateListener { updateValue ->
//                binding.textView.text = updateValue.animatedValue.toString()
//            }
//        }
//
//        binding.startBtn.setOnClickListener {
//            if (binding.textView.text.equals("0")){
//                setValueAnimatorEffect()
//            }else{
//                setValueAnimatorEffectReviers()
//            }
//
//        }
//    }
//
//    private fun setValueAnimatorEffectReviers() {
//        ValueAnimator.ofInt(10000, 0).apply {
//            duration = 3000
//            start()
//            addUpdateListener { updateValue ->
//                binding.textView.text = updateValue.animatedValue.toString()
//            }
//        }
//    }