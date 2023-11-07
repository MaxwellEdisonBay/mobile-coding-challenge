package com.audiobooks.podcasts.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.core_ui.navigation.parentViewModel
import com.audiobooks.core_ui.util.enterTransition
import com.audiobooks.core_ui.util.exitTransition
import com.audiobooks.core_ui.util.popEnterTransition
import com.audiobooks.core_ui.util.popExitTransition
import com.audiobooks.podcasts.SharedViewModel
import com.audiobooks.podcasts.details.DetailsScreen
import com.audiobooks.podcasts.landing.LandingScreen

fun NavGraphBuilder.injectPodcastsNavGraph(navController: NavController) {
    navigation(
        route = BottomNavGraphs.Podcasts.route,
        startDestination = PodcastsRoutes.Landing.route
    ) {
        composable(route = PodcastsRoutes.Landing.route,
            enterTransition = {
                enterTransition
            },
            exitTransition = {
                exitTransition
            },
            popEnterTransition = {
                popEnterTransition
            },
            popExitTransition = {
                popExitTransition
            }
        ) {
            val sharedViewModel: SharedViewModel = it.parentViewModel(navController = navController)
            LandingScreen(navController, sharedViewModel)
        }
        composable(route = PodcastsRoutes.Details.route,
            enterTransition = { enterTransition },
            popExitTransition = { popExitTransition }
        ) {
            val sharedViewModel: SharedViewModel = it.parentViewModel(navController = navController)
            DetailsScreen(navController, sharedViewModel)
        }
    }
}