package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class PriceRange(

    @SerializedName("min")
    var min: Int? = null,
)