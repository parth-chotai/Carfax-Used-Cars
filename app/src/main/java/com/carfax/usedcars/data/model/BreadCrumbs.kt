package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class BreadCrumbs(

    @SerializedName("label")
    var label: String? = null,

    @SerializedName("link")
    var link: String? = null,

    @SerializedName("position")
    var position: Int? = null,
)