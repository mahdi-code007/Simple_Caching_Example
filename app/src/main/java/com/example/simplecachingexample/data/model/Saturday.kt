package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Saturday(
    @SerializedName("closes_at")
    val closesAt: String?, // 9:42 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // false
    @SerializedName("opens_at")
    val opensAt: String? // 6:38 AM
)