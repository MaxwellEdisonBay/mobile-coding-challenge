package com.audiobooks.podcastapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core_ui.components.bottombar.BottomBarScaffold
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
internal fun MainScreen() {
    val navController = rememberNavController()

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PodcastAppTheme.colors.background
    ) {
        BottomBarScaffold(navController = navController) {
            MainNavigationGraph(
                navHostController = navController,
            )
        }
    }
}