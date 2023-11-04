package com.audiobooks.dashboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.audiobooks.dashboard.state.DashboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class DashboardViewModel @Inject constructor(): ViewModel() {
    private val _dashboardState = mutableStateOf(DashboardState())
    internal val dashboardState: State<DashboardState> = _dashboardState
}