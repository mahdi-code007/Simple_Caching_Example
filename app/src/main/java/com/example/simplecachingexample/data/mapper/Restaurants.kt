package com.example.simplecachingexample.data.mapper

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Restaurants_Table")
data class Restaurants(
    @SerializedName("address")
    val address: String?, // Suite 219 86703 Gordon Falls, New Augustineport, LA 97324-2120
    @SerializedName("id")
    @PrimaryKey
    val id: Int?,
    @SerializedName("logo")
    val logo: String?, // https://loremflickr.com/500/500/restaurant
    @SerializedName("name")
    val name: String?, // Spice Grill & Tap
    @SerializedName("type")
    val type: String? // Brazilian

)
