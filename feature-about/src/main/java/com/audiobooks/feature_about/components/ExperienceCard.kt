package com.audiobooks.feature_about.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.audiobooks.core_ui.components.card.SmallListImageCard
import com.audiobooks.core_ui.theme.PodcastAppTheme

/**
 * SmallListImageCard variation for experience section in About
 *
 * @param imageRes image drawable entry
 * @param imageAlt content desc
 * @param title card text title
 * @param employer your employer
 * @param dates dates of the employment
 * @param location work location in past
 * @param desc text description
 */
@Composable
internal fun ExperienceCard(
    @DrawableRes imageRes: Int,
    @StringRes imageAlt: Int,
    @StringRes title: Int,
    @StringRes employer: Int,
    @StringRes dates: Int,
    @StringRes location: Int,
    @StringRes desc: Int,
) {
    SmallListImageCard(
        image = {
            Image(
                modifier = Modifier
                    .size(PodcastAppTheme.dimensions.cardImageSmall)
                    .clip(PodcastAppTheme.shapes.smallCornerShape),
                painter = painterResource(id = imageRes),
                contentDescription = stringResource(id = imageAlt)
            )
        },
        content = {
            Text(text = stringResource(id = title), style = PodcastAppTheme.typography.h2)
            Text(text = stringResource(id = employer), style = PodcastAppTheme.typography.body)
            Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingSmall))
            Text(
                text = stringResource(id = dates),
                style = PodcastAppTheme.typography.subtitle,
                color = PodcastAppTheme.colors.textSecondary
            )
            Text(
                text = stringResource(id = location),
                style = PodcastAppTheme.typography.subtitle,
                color = PodcastAppTheme.colors.textSecondary
            )
            Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingSmall))
            Text(text = stringResource(id = desc), style = PodcastAppTheme.typography.body)
        }
    )
}