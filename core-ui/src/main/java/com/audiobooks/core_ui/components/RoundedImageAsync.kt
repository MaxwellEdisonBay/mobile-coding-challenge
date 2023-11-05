package com.audiobooks.core_ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.audiobooks.core_ui.R
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun RoundedImageAsync(
    url: String,
    @StringRes contentDescRes: Int,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .placeholder(R.drawable.placeholder)
            .build(),
        contentDescription = stringResource(id = contentDescRes),
        modifier = modifier.clip(PodcastAppTheme.shapes.mediumCornerShape)
    )
}