package com.carfax.usedcars.data.repository

import com.carfax.usedcars.data.api.ICarfaxApiService
import com.carfax.usedcars.data.model.UsedCars
import com.carfax.usedcars.util.NetworkResult
import javax.inject.Inject


class UsedCarsRepositoryImpl @Inject constructor(
    private val iCarfaxApiService: ICarfaxApiService,
) : IUsedCarsRepository {

    override suspend fun getUsedCarsData(): NetworkResult<UsedCars> {
        try {
            val response = iCarfaxApiService.getUsedCarsData()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let { return NetworkResult.Success(it) }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun error(errorMessage: String): NetworkResult.Error =
        NetworkResult.Error("Api call failed $errorMessage")
}