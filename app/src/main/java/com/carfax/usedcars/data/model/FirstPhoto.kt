package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class FirstPhoto(

    @SerializedName("large")
    var large: String? = null,

    @SerializedName("medium")
    var medium: String? = null,

    @SerializedName("small")
    var small: String? = null,
)