package com.carfax.usedcars.data.model

import com.carfax.usedcars.data.model.Facets
import com.google.gson.annotations.SerializedName


data class FuelType(

    @SerializedName("facets")
    var facets: List<Facets> = listOf(),
)