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
    // todo: wanted to use navigation animations, hence the AnimatedNavController
    //  but couldn't implement it due to time constraints but a thing for future maybe
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController,
        startDestination = Routes.usedCarsListingRouteId,
        route = Routes.rootRouteId
    ) {
        composable(route = Routes.usedCarsListingRouteId) {
            UsedCarsListings(cars = cars) {
                viewModel.saveClickedCar(it)
                navController.navigate("car-details")
            }
        }

        composable(route = Routes.carDetailsRouteId) {
            viewModel.car?.let {
                CarDetailsScreen(car = it) {
                    navController.popBackStack()
                }
            }
        }
    }
}