package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class AccidentHistory(

    @SerializedName("accidentSummary")
    var accidentSummary: List<String> = listOf(),

    @SerializedName("icon")
    var icon: String? = null,

    @SerializedName("iconUrl")
    var iconUrl: String? = null,

    @SerializedName("text")
    var text: String? = null,
)