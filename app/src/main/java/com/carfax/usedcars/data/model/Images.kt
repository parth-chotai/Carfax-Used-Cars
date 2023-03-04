package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class Images(

    @SerializedName("baseUrl")
    var baseUrl: String? = null,

    @SerializedName("firstPhoto")
    var firstPhoto: FirstPhoto? = FirstPhoto(),

    @SerializedName("large")
    var large: List<String> = listOf(),

    @SerializedName("medium")
    var medium: List<String> = listOf(),

    @SerializedName("small")
    var small: List<String> = listOf(),
)