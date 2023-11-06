package com.audiobooks.core_ui.components.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.audiobooks.core_ui.navigation.BottomNavGraphs
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
internal fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomNavGraphs.TechStack,
        BottomNavGraphs.Podcasts,
        BottomNavGraphs.About
    )
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomBarItem(navController = navController, screen = screen, isSelected = isSelected)
        }
    }
}

@Composable
internal fun RowScope.BottomBarItem(
    navController: NavController,
    screen: BottomNavGraphs,
    isSelected: Boolean
) {
    NavigationBarItem(
        icon = {
            Icon(
                if (isSelected) screen.selectedIcon else screen.unSelectedIcon,
                contentDescription = stringResource(id = screen.nameAlt)
            )
        },
        label = { Text(stringResource(screen.name), style = PodcastAppTheme.typography.caption, fontWeight = FontWeight.Bold) },
        selected = isSelected,
        onClick = {
            navController.navigate(screen.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
    )
}