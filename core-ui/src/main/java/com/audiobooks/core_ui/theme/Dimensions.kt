package com.audiobooks.core_ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val paddingSmall: Dp = 4.dp,
    val paddingMedium: Dp = 8.dp,
    val paddingLarge: Dp = 24.dp,
    val pageContentPadding: Dp = 20.dp
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }