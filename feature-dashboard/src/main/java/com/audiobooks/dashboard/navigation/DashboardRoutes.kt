package com.audiobooks.dashboard.navigation

internal sealed class DashboardRoutes(val route: String) {
    object Dashboard: DashboardRoutes("dashboard_screen")
}
