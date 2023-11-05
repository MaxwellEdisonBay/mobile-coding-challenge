package com.audiobooks.core_ui.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.audiobooks.core_ui.R
import com.audiobooks.core_ui.components.RoundedImageAsync
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun MediumListImageCard(
    title: String,
    subTitle: String,
    imageUrl: String,
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PodcastAppTheme.colors.background),
        horizontalArrangement = Arrangement.Start
    ) {
        RoundedImageAsync(
            modifier = Modifier.size(PodcastAppTheme.dimensions.cardImageMedium),
            url = imageUrl,
            contentDescRes = R.string.core_ui_card_image_alt
        )
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingMedium))
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .height(PodcastAppTheme.dimensions.cardImageMedium)
        ) {
            Text(text = title, style = PodcastAppTheme.typography.h3)
            Text(
                text = subTitle,
                style = PodcastAppTheme.typography.subtitle,
                color = PodcastAppTheme.colors.textSecondary
            )
            if (isFavorite) {
                Text(
                    text = stringResource(id = R.string.core_ui_card_favourite_text),
                    color = PodcastAppTheme.colors.primary
                )
            }

        }
    }
}


@Preview
@Composable
fun MediumListImageCardPreview() {
    MediumListImageCard(
        title = "The Indicator from Planet Money",
        subTitle = "NPR",
        imageUrl = "https://production.listennotes.com/podcasts/the-rough-cut-matt-feury-DEkF_8ybj6A-53MLh7NpAwm.300x300.jpg"
    )
}
