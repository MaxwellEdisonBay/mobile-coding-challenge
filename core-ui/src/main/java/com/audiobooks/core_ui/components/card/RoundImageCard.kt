package com.audiobooks.core_ui.components.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.audiobooks.core_ui.R
import com.audiobooks.core_ui.components.CircleImage
import com.audiobooks.core_ui.theme.PodcastAppTheme

/**
 * Card components with large round image
 *
 * @param imageRes image drawable resource
 * @param imageAlt image content description
 * @param title card title
 * @param desc card description
 */
@Composable
fun RoundImageCard(
    @DrawableRes imageRes: Int,
    imageAlt: String,
    title: String,
    desc: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PodcastAppTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleImage(
            modifier = Modifier.size(PodcastAppTheme.dimensions.cardImageLarge),
            imageRes = imageRes,
            imageAltStr = imageAlt
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(0.7f),
                style = PodcastAppTheme.typography.h1
            )
            Text(
                text = desc,
                modifier = Modifier.fillMaxWidth(0.7f),
                style = PodcastAppTheme.typography.subtitle,
                color = PodcastAppTheme.colors.textSecondary
            )
        }
    }
}

@Composable
@Preview
private fun RoundImageCardPreview() {
    RoundImageCard(
        imageRes = R.drawable.placeholder,
        imageAlt = "alt",
        title = "Title",
        desc = "descdescdescdescdescdescdesc"
    )
}