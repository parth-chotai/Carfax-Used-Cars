package com.carfax.usedcars.data.repository

import com.carfax.usedcars.data.model.UsedCars
import com.carfax.usedcars.util.NetworkResult

interface IUsedCarsRepository {

    suspend fun getUsedCarsData(): NetworkResult<UsedCars>
}