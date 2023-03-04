package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class History(

    @SerializedName("averageMilesPerYear")
    var averageMilesPerYear: Int? = null,

    @SerializedName("ownerNumber")
    var ownerNumber: Int? = null,

    @SerializedName("useType")
    var useType: String? = null,
)