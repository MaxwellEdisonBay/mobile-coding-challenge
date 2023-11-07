package com.audiobooks.feature_techstack.navigation

import androidx.annotation.DrawableRes

/**
 * TechStack module routes declaration
 *
 * @param route route value.
 * @param name route text name (optional).
 * @param icon route display icon (optional).
 */
internal sealed class TechStackRoutes(
    internal val route: String,
    internal val name: String? = null,
    @DrawableRes internal val icon: Int? = null
) {
    object TechStack: TechStackRoutes("techstack_screen")
}
