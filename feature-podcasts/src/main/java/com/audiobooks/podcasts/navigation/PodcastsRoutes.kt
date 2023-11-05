package com.audiobooks.podcasts.navigation

import androidx.annotation.DrawableRes

internal sealed class PodcastsRoutes(
    internal val route: String,
    internal val name: String? = null,
    @DrawableRes internal val icon: Int? = null
) {
    object Landing: PodcastsRoutes("landing_screen")
    object Details: PodcastsRoutes("details_screen")
}
