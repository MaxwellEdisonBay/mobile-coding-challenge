package com.audiobooks.core_ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object PodcastAppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val shapes: AppShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Composable
fun PodcastAppTheme(
    colors: AppColors = PodcastAppTheme.colors,
    typography: AppTypography = PodcastAppTheme.typography,
    dimensions: AppDimensions = PodcastAppTheme.dimensions,
    shapes: AppShapes = PodcastAppTheme.shapes,
    content: @Composable () -> Unit
) {
    // Explicitly creating a new object here so we don't mutate the initial [colors]
    // provided, and overwrite the values set in it.
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography,
        LocalShapes provides shapes
    ) {
        content()
    }
}