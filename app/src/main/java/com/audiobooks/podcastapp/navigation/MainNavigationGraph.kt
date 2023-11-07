package com.audiobooks.podcastapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.feature_about.navigation.injectAboutNavGraph
import com.audiobooks.feature_techstack.navigation.injectTechStackNavGraph
import com.audiobooks.podcasts.navigation.injectPodcastsNavGraph

/**
 * Root navigation graph. Injected directly to MainActivity
 */
@Composable
internal fun MainNavigationGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        route = BottomNavGraphs.Root.route,
        startDestination = BottomNavGraphs.Podcasts.route
    ) {
        injectPodcastsNavGraph(navHostController)
        injectTechStackNavGraph(navHostController)
        injectAboutNavGraph(navHostController)
    }
}