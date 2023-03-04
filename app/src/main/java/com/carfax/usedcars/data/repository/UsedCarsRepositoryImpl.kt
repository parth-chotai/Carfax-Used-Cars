package com.carfax.usedcars.data.repository

import com.carfax.usedcars.data.api.ICarfaxApiService
import com.carfax.usedcars.data.model.UsedCars
import com.carfax.usedcars.util.NetworkResult
import javax.inject.Inject


class UsedCarsRepositoryImpl @Inject constructor(
    private val iCarfaxApiService: ICarfaxApiService,
) : IUsedCarsRepository {

    override suspend fun getUsedCarsData(): NetworkResult<UsedCars> {
        val response = try {
            iCarfaxApiService.getUsedCarsData()
        } catch (ex: Exception) {
            return NetworkResult.Error(ex)
        }
        return NetworkResult.Success(response)
    }
}