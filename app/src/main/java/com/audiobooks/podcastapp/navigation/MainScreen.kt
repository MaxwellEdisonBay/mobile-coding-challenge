package com.audiobooks.podcastapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core_ui.components.BaseScaffold

@Composable
internal fun MainScreen() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        BaseScaffold(navController = navController) {
            MainNavigationGraph(
                navHostController = navController,
            )
        }
    }
}