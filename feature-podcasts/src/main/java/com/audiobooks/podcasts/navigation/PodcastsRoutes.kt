package com.audiobooks.podcasts.navigation

import androidx.annotation.DrawableRes

/**
 * Podcasts module routes declaration
 *
 * @param route route value.
 * @param name route text name (optional).
 * @param icon route display icon (optional).
 */
internal sealed class PodcastsRoutes(
    internal val route: String,
    internal val name: String? = null,
    @DrawableRes internal val icon: Int? = null
) {
    object Landing: PodcastsRoutes("landing_screen")
    object Details: PodcastsRoutes("details_screen")
}
