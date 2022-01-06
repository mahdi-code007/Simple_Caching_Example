package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Thursday(
    @SerializedName("closes_at")
    val closesAt: String?, // 7:57 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // false
    @SerializedName("opens_at")
    val opensAt: String? // 9:23 AM
)