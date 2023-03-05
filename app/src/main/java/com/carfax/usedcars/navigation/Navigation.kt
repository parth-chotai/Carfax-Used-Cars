package com.carfax.usedcars.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.carfax.usedcars.data.model.Listings
import com.carfax.usedcars.ui.views.CarDetailsScreen
import com.carfax.usedcars.ui.views.UsedCarsListings
import com.carfax.usedcars.viewmodel.UsedCarsViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    cars: List<Listings>,
    viewModel: UsedCarsViewModel,
) {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController,
        startDestination = "used-cars",
        route = "root-toute"
    ) {
        composable(route = "used-cars") {
            UsedCarsListings(cars = cars) {
                viewModel.saveClickedCar(it)
                navController.navigate("car-details")
            }
        }

        composable(route = "car-details") {
            viewModel.car?.let {
                CarDetailsScreen(car = it) {
                    navController.popBackStack()
                }
            }
        }
    }
}