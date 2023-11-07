package com.audiobooks.core_ui.util

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment

const val EXPANSION_OBJECT_ANIMATION_TIME_DURATION = 600

val enterTransition: EnterTransition by lazy {
    slideInHorizontally(
        initialOffsetX = { 300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
}

val exitTransition: ExitTransition by lazy {
    slideOutHorizontally(
        targetOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
}

val popEnterTransition: EnterTransition by lazy {
    slideInHorizontally(
        initialOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
}

val popExitTransition: ExitTransition by lazy {
    slideOutHorizontally(
        targetOffsetX = { 300 },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
}

val objectEnterTransition by lazy {
    expandVertically(
        expandFrom = Alignment.Top,
        animationSpec = tween(EXPANSION_OBJECT_ANIMATION_TIME_DURATION)
    ) + fadeIn(initialAlpha = .3f, animationSpec = tween(EXPANSION_OBJECT_ANIMATION_TIME_DURATION))
}

val objectSlideInVerticallyTransition by lazy {
    slideInVertically(
        animationSpec = tween(
            EXPANSION_OBJECT_ANIMATION_TIME_DURATION,
            delayMillis = 200
        ), initialOffsetY = { it / 2 }) + fadeIn(
        initialAlpha = .1f,
        animationSpec = tween(EXPANSION_OBJECT_ANIMATION_TIME_DURATION, delayMillis = 200)
    )
}