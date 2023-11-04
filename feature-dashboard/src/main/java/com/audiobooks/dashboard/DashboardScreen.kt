package com.audiobooks.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val state = viewModel.dashboardState.value

    Box(modifier = Modifier.fillMaxSize()) {
        // TODO: Implement Dashboard UI
        Text("Dashboard Screen")
    }
}