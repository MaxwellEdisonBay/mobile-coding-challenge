package com.audiobooks.podcastapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.podcasts.navigation.injectPodcastsNavGraph

@Composable
internal fun MainNavigationGraph(
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navHostController,
        route = BottomNavGraphs.Root.route,
        startDestination = startDestination
    ) {
        injectPodcastsNavGraph(navHostController)
    }
}