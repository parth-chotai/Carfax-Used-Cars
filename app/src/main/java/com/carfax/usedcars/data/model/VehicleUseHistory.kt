package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class VehicleUseHistory(

    @SerializedName("history")
    var history: List<History> = listOf(),

    @SerializedName("icon")
    var icon: String? = null,

    @SerializedName("iconUrl")
    var iconUrl: String? = null,

    @SerializedName("text")
    var text: String? = null,
)