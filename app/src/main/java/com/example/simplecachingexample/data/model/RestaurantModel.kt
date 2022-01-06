package com.example.simplecachingexample.data.model


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class RestaurantModel(
    @SerializedName("address")
    val address: String?, // Suite 219 86703 Gordon Falls, New Augustineport, LA 97324-2120
    @SerializedName("description")
    val description: String?, // Culver’s Restaurant was founded by the Culver family in 1984, which eventually branched out to more than 300 franchised restaurants all over the US. Culver’s is well-known for its ButterBurger, which made the restaurant extremely famous. They also have other items which include salads, sandwiches, desserts, etc.
    @SerializedName("id")
    val id: Int?, // 6343
    @SerializedName("logo")
    val logo: String?, // https://loremflickr.com/500/500/restaurant
    @SerializedName("name")
    val name: String?, // Spice Grill & Tap
    @SerializedName("phone_number")
    val phoneNumber: String?, // 207.448.9258 x40249
    @SerializedName("review")
    val review: String?, // In terms of omakase, they had a few options but the one we chose was the 87 dollar version which include sashimi and sushi.
    @SerializedName("type")
    val type: String?, // Brazilian
    @SerializedName("uid")
    val uid: String? // 7fcc3cc5-44b8-490c-8821-0615b3340616
){
    @SerializedName("hours")
    val hours: Hours? = null

}