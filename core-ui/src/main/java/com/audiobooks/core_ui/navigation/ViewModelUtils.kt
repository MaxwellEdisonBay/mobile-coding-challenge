package com.audiobooks.core_ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun rememberParentViewModelStoreOwner(
    navController: NavController,
    parentRoute: String,
): ViewModelStoreOwner {
    return remember(navController.currentBackStackEntry) {
        object : ViewModelStoreOwner {
            override val viewModelStore =
                navController.getBackStackEntry(parentRoute).viewModelStore
        }
    }
}

@Composable
inline fun <reified VM : ViewModel> NavBackStackEntry.parentViewModel(
    navController: NavController
): VM {
    // First, get the parent of the current destination
    // This always exists since every destination in your graph has a parent
    val parentId = destination.parent?.route ?: ""
    // Now get the NavBackStackEntry associated with the parent

    val sharedViewModelStoreOwner = rememberParentViewModelStoreOwner(
        navController = navController,
        parentRoute = parentId
    )

    return hiltViewModel(sharedViewModelStoreOwner)
}