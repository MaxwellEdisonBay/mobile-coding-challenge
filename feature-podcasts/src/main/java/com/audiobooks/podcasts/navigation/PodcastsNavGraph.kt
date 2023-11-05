package com.audiobooks.podcasts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.podcasts.details.DetailsScreen
import com.audiobooks.podcasts.landing.LandingScreen

fun NavGraphBuilder.injectPodcastsNavGraph(navController: NavController) {
    navigation(
        route = BottomNavGraphs.Podcasts.route,
        startDestination = PodcastsRoutes.Landing.route
    ) {
        composable(route = PodcastsRoutes.Landing.route) {
            LandingScreen(navController)
        }
        composable(route = PodcastsRoutes.Details.route) {
            DetailsScreen(navController)
        }
    }
}