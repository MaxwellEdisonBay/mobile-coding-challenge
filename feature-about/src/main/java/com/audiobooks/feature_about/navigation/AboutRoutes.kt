package com.audiobooks.feature_about.navigation

import androidx.annotation.DrawableRes

internal sealed class AboutRoutes(
    internal val route: String,
    internal val name: String? = null,
    @DrawableRes internal val icon: Int? = null
) {
    object About: AboutRoutes("about_screen")
}
