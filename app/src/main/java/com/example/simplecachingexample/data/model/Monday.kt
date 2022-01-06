package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Monday(
    @SerializedName("closes_at")
    val closesAt: String?, // 4:52 PM
    @SerializedName("is_closed")
    val isClosed: Boolean?, // true
    @SerializedName("opens_at")
    val opensAt: String? // 9:19 AM
)