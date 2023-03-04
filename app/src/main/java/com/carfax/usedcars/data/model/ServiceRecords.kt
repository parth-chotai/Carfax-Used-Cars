package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class ServiceRecords(

    @SerializedName("facets")
    var facets: List<Facets> = listOf(),
)