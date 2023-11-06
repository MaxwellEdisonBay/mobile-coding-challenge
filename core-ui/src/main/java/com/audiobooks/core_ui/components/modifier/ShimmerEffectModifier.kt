package com.audiobooks.core_ui.components.modifier

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.audiobooks.core_ui.theme.PodcastAppTheme

fun Modifier.shimmerEffect(isLoading: Boolean): Modifier =
    if (isLoading) {
        composed {
            var size by remember { mutableStateOf(IntSize.Zero) }
            val transition = rememberInfiniteTransition(label = "")
            val startOffsetX by transition.animateFloat(
                initialValue = -2 * size.width.toFloat(),
                targetValue = 2 * size.width.toFloat(),
                animationSpec = infiniteRepeatable(
                    animation = tween(1200, easing = LinearEasing)
                ), label = ""
            )

            background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.LightGray,
                        Color.LightGray.copy(alpha = 0.4f)
                    ),
                    start = Offset(startOffsetX, 0f),
                    end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
                ),
                shape = PodcastAppTheme.shapes.mediumCornerShape
            )
                .onGloballyPositioned {
                    size = it.size
                }
        }
    } else {
        this
    }