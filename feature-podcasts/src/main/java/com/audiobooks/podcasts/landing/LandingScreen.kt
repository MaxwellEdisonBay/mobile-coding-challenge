package com.audiobooks.podcasts.landing

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.audiobooks.core_ui.components.BaseScaffold

@Composable
internal fun LandingScreen(
    navController: NavController,
    viewModel: LandingViewModel = hiltViewModel(),
) {
    val state = viewModel.landingState.value
    BaseScaffold(navController = navController) {
        Text("Landing Screen")
    }
}