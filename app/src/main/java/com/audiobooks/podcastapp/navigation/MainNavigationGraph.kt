package com.audiobooks.podcastapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.audiobooks.podcasts.navigation.injectPodcastsNavGraph

@Composable
internal fun MainNavigationGraph(
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navHostController,
        route = Graphs.ROOT,
        startDestination = startDestination
    ) {
        injectPodcastsNavGraph(navHostController, Graphs.PODCASTS)
    }
}

object Graphs {
    const val ROOT = "root_graph"
    const val PODCASTS = "podcasts_graph"
}