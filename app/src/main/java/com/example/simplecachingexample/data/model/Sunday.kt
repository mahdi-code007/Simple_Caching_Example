package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Sunday(
    @SerializedName("closes_at")
    val closesAt: String?, // 5:46 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // false
    @SerializedName("opens_at")
    val opensAt: String? // 7:35 AM
)