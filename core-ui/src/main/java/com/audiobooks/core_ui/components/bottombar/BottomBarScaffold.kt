package com.audiobooks.core_ui.components.bottombar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/**
 * Base container for bottom nav bar and app content
 * [navController] is used to navigate through the graph
 * [content] app content
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBarScaffold(navController: NavController, content: @Composable () -> Unit) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}