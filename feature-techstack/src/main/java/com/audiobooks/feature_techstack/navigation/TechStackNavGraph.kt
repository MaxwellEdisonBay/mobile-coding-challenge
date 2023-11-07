package com.audiobooks.feature_techstack.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.core_ui.util.enterTransition
import com.audiobooks.core_ui.util.exitTransition
import com.audiobooks.core_ui.util.popEnterTransition
import com.audiobooks.feature_techstack.TechStackScreen

/**
 * Injects TechStack routes to the main nav graph. Declare module routes here
 *
 * [navController] - controls navigation
 */
fun NavGraphBuilder.injectTechStackNavGraph(navController: NavController) {
    navigation(
        route = BottomNavGraphs.TechStack.route,
        startDestination = TechStackRoutes.TechStack.route
    ) {
        composable(route = TechStackRoutes.TechStack.route,
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
            TechStackScreen(navController)
        }
    }
}