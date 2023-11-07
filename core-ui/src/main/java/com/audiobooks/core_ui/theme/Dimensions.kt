package com.audiobooks.core_ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val paddingXSmall: Dp = 2.dp,
    val paddingSmall: Dp = 4.dp,
    val paddingBigger: Dp = 8.dp,
    val paddingMedium: Dp = 12.dp,
    val paddingLarge: Dp = 24.dp,

    val pageContentPadding: Dp = 20.dp,

    val cardImageSmall: Dp = 50.dp,
    val cardImageMedium: Dp = 100.dp,

    val iconImageSmall: Dp = 16.dp,
    val iconImageMedium: Dp = 20.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }