package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class Facets(

    @SerializedName("encodedName")
    var encodedName: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("value")
    var value: Int? = null,
)