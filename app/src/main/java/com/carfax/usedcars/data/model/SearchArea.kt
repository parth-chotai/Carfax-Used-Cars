package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class SearchArea(

    @SerializedName("city")
    var city: String? = null,

    @SerializedName("dynamicRadii")
    var dynamicRadii: List<Int> = listOf(),

    @SerializedName("dynamicRadius")
    var dynamicRadius: Boolean? = null,

    @SerializedName("latitude")
    var latitude: Double? = null,

    @SerializedName("longitude")
    var longitude: Double? = null,

    @SerializedName("radius")
    var radius: Int? = null,

    @SerializedName("state")
    var state: String? = null,

    @SerializedName("zip")
    var zip: String? = null,
)