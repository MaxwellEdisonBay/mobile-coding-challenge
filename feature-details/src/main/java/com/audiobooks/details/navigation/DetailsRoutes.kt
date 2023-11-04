package com.audiobooks.details.navigation

internal sealed class DetailsRoutes(val route: String) {
    object Details: DetailsRoutes("details_screen")
}