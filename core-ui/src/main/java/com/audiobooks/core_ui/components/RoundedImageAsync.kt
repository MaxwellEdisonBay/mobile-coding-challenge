package com.audiobooks.core_ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun RoundedImageAsync(
    url : String,
    @StringRes contentDescRes: Int,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = url,
        contentDescription = stringResource(id = contentDescRes),
        modifier = modifier.clip(PodcastAppTheme.shapes.mediumCornerShape)
    )
}