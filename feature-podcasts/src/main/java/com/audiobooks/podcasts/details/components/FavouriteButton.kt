package com.audiobooks.podcasts.details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.podcasts.R

@Composable
internal fun FavouriteButton(favourite: Boolean, onClick: () -> Unit) {
    Button(
        shape = PodcastAppTheme.shapes.mediumCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (favourite) {
                Color.Transparent
            } else {
                PodcastAppTheme.colors.primary
            }
        ),
        border = BorderStroke(
            1.dp, if (favourite) {
                PodcastAppTheme.colors.error
            } else {
                PodcastAppTheme.colors.primary
            }
        ),
        onClick = onClick
    ) {
        Icon(
            imageVector = if (favourite) {
                Icons.Filled.Delete
            } else {
                Icons.Filled.Star
            },
            contentDescription = null,
            tint = if (favourite) {
                PodcastAppTheme.colors.error
            } else {
                PodcastAppTheme.colors.background

            },
        )
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingSmall))
        Text(
            text = stringResource(
                id = if (favourite) {
                    R.string.feature_podcast_details_favourite_button_favourite
                } else {
                    R.string.feature_podcast_details_favourite_button_add
                }
            ),
            color = if (favourite) {
                PodcastAppTheme.colors.error
            } else {
                PodcastAppTheme.colors.background
            },
            style = PodcastAppTheme.typography.h3
        )
    }
}