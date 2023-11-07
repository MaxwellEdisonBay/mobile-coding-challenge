package com.audiobooks.feature_about.navigation

import androidx.annotation.DrawableRes

/**
 * About module routes declaration
 *
 * @param route route value.
 * @param name route text name (optional).
 * @param icon route display icon (optional).
 */
internal sealed class AboutRoutes(
    internal val route: String,
    internal val name: String? = null,
    @DrawableRes internal val icon: Int? = null
) {
    object About: AboutRoutes("about_screen")
}
