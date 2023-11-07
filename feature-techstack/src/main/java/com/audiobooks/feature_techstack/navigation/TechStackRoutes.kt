package com.audiobooks.feature_techstack.navigation

import androidx.annotation.DrawableRes

internal sealed class TechStackRoutes(
    internal val route: String,
    internal val name: String? = null,
    @DrawableRes internal val icon: Int? = null
) {
    object TechStack: TechStackRoutes("techstack_screen")
}
