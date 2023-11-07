package com.audiobooks.feature_about.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.core_ui.util.enterTransition
import com.audiobooks.core_ui.util.exitTransition
import com.audiobooks.core_ui.util.popEnterTransition
import com.audiobooks.feature_about.AboutScreen

/**
 * Injects About routes to the main nav graph. Declare module routes here
 *
 * [navController] - controls navigation
 */
fun NavGraphBuilder.injectAboutNavGraph(navController: NavController) {
    navigation(
        route = BottomNavGraphs.About.route,
        startDestination = AboutRoutes.About.route
    ) {
        composable(route = AboutRoutes.About.route,
            enterTransition = {
                enterTransition
            },
            exitTransition = {
                exitTransition
            },
            popEnterTransition = {
                popEnterTransition
            }
        ) {
            AboutScreen(navController)
        }
    }
}