package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Tuesday(
    @SerializedName("closes_at")
    val closesAt: String?, // 1:28 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // true
    @SerializedName("opens_at")
    val opensAt: String? // 9:31 AM
)