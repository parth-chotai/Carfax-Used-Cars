package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class MileageRange(

    @SerializedName("max")
    var max: Int? = null,

    @SerializedName("min")
    var min: Int? = null,
)