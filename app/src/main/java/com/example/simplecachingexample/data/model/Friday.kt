package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Friday(
    @SerializedName("closes_at")
    val closesAt: String?, // 9:36 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // true
    @SerializedName("opens_at")
    val opensAt: String? // 8:22 AM
)