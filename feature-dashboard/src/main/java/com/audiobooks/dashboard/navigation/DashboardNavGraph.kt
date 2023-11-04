package com.audiobooks.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.dashboard.DashboardScreen

fun NavGraphBuilder.injectDashboardNavGraph(navController: NavController, graphRoute: String) {
    navigation(
        route = graphRoute,
        startDestination = DashboardRoutes.Dashboard.route
    ) {
        composable(route = DashboardRoutes.Dashboard.route) {
            DashboardScreen()
        }
    }
}