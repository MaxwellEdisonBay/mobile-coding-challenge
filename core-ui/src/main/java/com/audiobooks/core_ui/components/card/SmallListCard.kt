package com.audiobooks.core_ui.components.card

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.audiobooks.core_ui.R
import com.audiobooks.core_ui.components.RoundedImageAsync
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun SmallListImageCard(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    @DrawableRes imageRes: Int? = null,
    @StringRes imageAltText: Int = R.string.core_ui_card_image_alt,
    content: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PodcastAppTheme.colors.background),
        horizontalArrangement = Arrangement.Start
    ) {
        RoundedImageAsync(
            modifier = Modifier
                .size(PodcastAppTheme.dimensions.cardImageSmall),
            url = imageUrl,
            imageRes = imageRes,
            contentDescRes = imageAltText
        )
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingMedium))
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .height(PodcastAppTheme.dimensions.cardImageMedium)
        ) {
            content()
        }
    }
}


@Preview
@Composable
fun SmallListImageCardPreview() {
    SmallListImageCard() {
        Text(text = "Test")
    }
}
