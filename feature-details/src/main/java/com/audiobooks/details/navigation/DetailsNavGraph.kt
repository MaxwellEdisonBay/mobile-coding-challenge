package com.audiobooks.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.details.DetailsScreen

fun NavGraphBuilder.injectDetailsNavGraph(navController: NavController, graphRoute: String) {
    navigation(
        route = graphRoute,
        startDestination = DetailsRoutes.Details.route
    ) {
        composable(route = DetailsRoutes.Details.route) {
            DetailsScreen()
        }
    }
}