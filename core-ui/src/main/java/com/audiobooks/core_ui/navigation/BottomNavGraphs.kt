package com.audiobooks.core_ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavGraphs(
    val route: String,
    val selectedIcon: ImageVector = Icons.Outlined.Warning,
    val unSelectedIcon: ImageVector = Icons.Outlined.Warning,
) {
    object Root : BottomNavGraphs(route = "root_graph")
    object Podcasts :
        BottomNavGraphs(route = "podcasts_graph", Icons.Filled.Home, Icons.Outlined.Home)
}