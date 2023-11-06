package com.audiobooks.core_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.audiobooks.core_ui.R
import com.audiobooks.core_ui.components.modifier.conditional
import com.audiobooks.core_ui.components.modifier.shimmerEffect
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun FilledTag(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isLoading: Boolean = false,
) {
    val cornerShape = PodcastAppTheme.shapes.largeCornerShape
    val background = PodcastAppTheme.colors.primary
    Row(
        modifier = modifier
            .conditional(!isLoading) {
                clip(cornerShape).background(background)
            }
            .conditional(isLoading) { fillMaxWidth(0.3f) }
            .shimmerEffect(isLoading),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingSmall))
        icon?.let {
            Icon(
                modifier = Modifier.padding(vertical = PodcastAppTheme.dimensions.paddingSmall).size(PodcastAppTheme.dimensions.iconImageSmall),
                imageVector = it,
                contentDescription = stringResource(id = R.string.core_ui_filled_tag_icon_alt),
                tint = PodcastAppTheme.colors.background
            )
            Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingXSmall))
        }
        Text(
            text = text,
            style = PodcastAppTheme.typography.caption,
            color = PodcastAppTheme.colors.background,
            modifier = Modifier.padding(vertical = PodcastAppTheme.dimensions.paddingSmall)
        )
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingSmall))
    }
}