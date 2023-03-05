package com.carfax.usedcars.data.api

import com.carfax.usedcars.BuildConfig
import com.carfax.usedcars.data.model.UsedCars
import retrofit2.Response
import retrofit2.http.GET

interface ICarfaxApiService {

    @GET(BuildConfig.BASE_URL)
    suspend fun getUsedCarsData(): Response<UsedCars>
}