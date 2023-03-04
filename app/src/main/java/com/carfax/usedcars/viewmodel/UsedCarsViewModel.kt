package com.carfax.usedcars.viewmodel

import androidx.lifecycle.ViewModel
import com.carfax.usedcars.data.repository.IUsedCarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsedCarsViewModel @Inject constructor(
    private val iUsedCarsRepository: IUsedCarsRepository,
) : ViewModel()