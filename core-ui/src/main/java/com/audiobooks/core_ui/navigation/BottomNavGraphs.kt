package com.audiobooks.core_ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.audiobooks.core_ui.R

/**
 * Routes for bottom nav graphs
 *
 * @param route route string value
 * @param name name of the destination
 * @param nameAlt content desc
 * @param selectedIcon selected icon ui
 * @param unSelectedIcon unselected icon ui
 */
sealed class BottomNavGraphs(
    val route: String,
    @StringRes val name: Int = R.string.core_ui_bottom_nav_podcasts_name,
    @StringRes val nameAlt: Int = R.string.core_ui_bottom_nav_podcasts_name_alt,
    val selectedIcon: ImageVector = Icons.Filled.Home,
    val unSelectedIcon: ImageVector = Icons.Outlined.Home,
) {
    object Root : BottomNavGraphs(route = "root_graph")
    object Podcasts :
        BottomNavGraphs(route = "podcasts_graph")

    object About :
        BottomNavGraphs(
            route = "about_graph",
            name = R.string.core_ui_bottom_nav_about_name,
            nameAlt = R.string.core_ui_bottom_nav_about_name_alt,
            Icons.Filled.AccountCircle,
            Icons.Outlined.AccountCircle
        )

    object TechStack :
        BottomNavGraphs(
            route = "techstack_graph",
            name = R.string.core_ui_bottom_nav_techstack_name,
            nameAlt = R.string.core_ui_bottom_nav_techstack_name_alt,
            Icons.Filled.Settings,
            Icons.Outlined.Settings
        )
}