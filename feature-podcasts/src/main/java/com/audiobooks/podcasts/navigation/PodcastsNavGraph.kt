package com.audiobooks.podcasts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.podcasts.details.DetailsScreen
import com.audiobooks.podcasts.landing.LandingScreen

fun NavGraphBuilder.injectPodcastsNavGraph(navController: NavController, graphRoute: String) {
    navigation(
        route = graphRoute,
        startDestination = PodcastsRoutes.Landing.route
    ) {
        composable(route = PodcastsRoutes.Landing.route) {
            LandingScreen()
        }
        composable(route = PodcastsRoutes.Details.route) {
            DetailsScreen()
        }
    }
}