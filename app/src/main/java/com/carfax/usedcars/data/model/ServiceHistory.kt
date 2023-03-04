package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class ServiceHistory(

    @SerializedName("history")
    var history: List<History> = listOf(),

    @SerializedName("icon")
    var icon: String? = null,

    @SerializedName("iconUrl")
    var iconUrl: String? = null,

    @SerializedName("number")
    var number: Int? = null,

    @SerializedName("text")
    var text: String? = null,
)