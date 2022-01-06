package com.example.simplecachingexample.data.model


import com.google.gson.annotations.SerializedName

data class Hours(
    @SerializedName("friday")
    val friday: Friday?,
    @SerializedName("monday")
    val monday: Monday?,
    @SerializedName("saturday")
    val saturday: Saturday?,
    @SerializedName("sunday")
    val sunday: Sunday?,
    @SerializedName("thursday")
    val thursday: Thursday?,
    @SerializedName("tuesday")
    val tuesday: Tuesday?,
    @SerializedName("wednesday")
    val wednesday: Wednesday?
)