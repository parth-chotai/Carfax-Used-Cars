package com.carfax.usedcars.data.model

import com.google.gson.annotations.SerializedName


data class UsedCars(

    @SerializedName("backfillCount")
    var backfillCount: Int? = null,

    @SerializedName("breadCrumbs")
    var breadCrumbs: List<BreadCrumbs> = listOf(),

    @SerializedName("dealerNewCount")
    var dealerNewCount: Int? = null,

    @SerializedName("dealerUsedCount")
    var dealerUsedCount: Int? = null,

    @SerializedName("enhancedCount")
    var enhancedCount: Int? = null,

    @SerializedName("facetCountMap")
    var facetCountMap: FacetCountMap? = FacetCountMap(),

    @SerializedName("listings")
    var listings: List<Listings> = listOf(),

    @SerializedName("page")
    var page: Int? = null,

    @SerializedName("pageSize")
    var pageSize: Int? = null,

    @SerializedName("searchArea")
    var searchArea: SearchArea? = SearchArea(),

    @SerializedName("searchRequest")
    var searchRequest: SearchRequest? = SearchRequest(),

    @SerializedName("seoUrl")
    var seoUrl: String? = null,

    @SerializedName("totalListingCount")
    var totalListingCount: Int? = null,

    @SerializedName("totalPageCount")
    var totalPageCount: Int? = null,
)