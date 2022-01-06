package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Wednesday(
    @SerializedName("closes_at")
    val closesAt: String?, // 3:42 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // true
    @SerializedName("opens_at")
    val opensAt: String? // 9:17 AM
)