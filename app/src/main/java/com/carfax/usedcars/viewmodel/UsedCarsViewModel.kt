package com.carfax.usedcars.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carfax.usedcars.data.model.Listings
import com.carfax.usedcars.data.model.UsedCars
import com.carfax.usedcars.data.repository.IUsedCarsRepository
import com.carfax.usedcars.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsedCarsViewModel @Inject constructor(
    private val iUsedCarsRepository: IUsedCarsRepository,
) : ViewModel() {

    //region Variables
    var usedCarsState by mutableStateOf<NetworkResult<UsedCars>>(value = NetworkResult.Loading)
        private set

    var car: Listings? = null
        private set
    //endregion

    init {
        getUsedCarsData()
    }

    //region Functions
    private fun getUsedCarsData() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val networkResult = iUsedCarsRepository.getUsedCarsData()) {
                is NetworkResult.Error -> {
                    usedCarsState = NetworkResult.Error(networkResult.message)
                }
                is NetworkResult.Success -> {
                    usedCarsState = NetworkResult.Success(networkResult.data)
                }
                else -> Unit
            }
        }
    }

    fun saveClickedCar(clickedCar: Listings) {
        car = clickedCar
    }
    //endregion
}