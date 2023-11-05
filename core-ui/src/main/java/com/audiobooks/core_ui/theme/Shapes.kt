package com.audiobooks.core_ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

data class AppShapes(
    val smallCornerShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    val mediumCornerShape: RoundedCornerShape = RoundedCornerShape(12.dp),
    val largeCornerShape: RoundedCornerShape = RoundedCornerShape(16.dp),
)

internal val LocalShapes = staticCompositionLocalOf { AppShapes() }