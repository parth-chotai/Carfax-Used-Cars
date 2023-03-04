package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class SearchRequest(

    @SerializedName("make")
    var make: String? = null,

    @SerializedName("mileageRange")
    var mileageRange: MileageRange? = MileageRange(),

    @SerializedName("model")
    var model: String? = null,

    @SerializedName("priceRange")
    var priceRange: PriceRange? = PriceRange(),

    @SerializedName("radius")
    var radius: Int? = null,

    @SerializedName("srpUrl")
    var srpUrl: String? = null,

    @SerializedName("webHost")
    var webHost: String? = null,

    @SerializedName("yearRange")
    var yearRange: YearRange? = YearRange(),

    @SerializedName("zip")
    var zip: String? = null,
)