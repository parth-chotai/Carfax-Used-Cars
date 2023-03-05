package com.carfax.usedcars

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.carfax.usedcars.navigation.Navigation
import com.carfax.usedcars.ui.theme.CarfaxUsedCarsTheme
import com.carfax.usedcars.ui.views.LoadingState
import com.carfax.usedcars.util.NetworkResult
import com.carfax.usedcars.viewmodel.UsedCarsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarfaxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: UsedCarsViewModel by viewModels()
        setContent {
            CarfaxUsedCarsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    when (val state = viewModel.usedCarsState) {
                        is NetworkResult.Error -> {
                            Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                        }
                        NetworkResult.Loading -> {
                            LoadingState()
                        }
                        is NetworkResult.Success -> {
                            Navigation(cars = state.data.listings, viewModel)
                        }
                    }
                }
            }
        }
    }
}