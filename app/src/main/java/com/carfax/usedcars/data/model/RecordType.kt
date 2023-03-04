package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class RecordType(

    @SerializedName("facets")
    var facets: List<Facets> = listOf(),
)