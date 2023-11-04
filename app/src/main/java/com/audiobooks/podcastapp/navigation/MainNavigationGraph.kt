package com.audiobooks.podcastapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.audiobooks.dashboard.navigation.injectDashboardNavGraph
import com.audiobooks.details.navigation.injectDetailsNavGraph

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
        injectDashboardNavGraph(navHostController, Graphs.DASHBOARD)
        injectDetailsNavGraph(navHostController, Graphs.DETAILS)
    }
}

object Graphs {
    const val ROOT = "root_graph"
    const val DASHBOARD = "dashboard_graph"
    const val DETAILS = "details_graph"
}