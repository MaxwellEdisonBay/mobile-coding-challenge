package com.audiobooks.feature_about.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
internal fun SocialLink(
    @DrawableRes iconRes: Int,
    @StringRes textRes: Int,
    tint: Color = PodcastAppTheme.colors.textPrimary,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onClick() }) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(PodcastAppTheme.dimensions.iconImageMedium),
            tint = tint
        )
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingSmall))
        Text(
            text = stringResource(id = textRes),
            style = PodcastAppTheme.typography.subtitle,
            color = PodcastAppTheme.colors.textSecondary
        )
    }
}