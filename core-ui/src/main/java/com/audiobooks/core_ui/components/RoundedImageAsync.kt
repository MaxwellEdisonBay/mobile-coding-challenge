package com.audiobooks.core_ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.audiobooks.core_ui.components.modifier.shimmerEffect
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun RoundedImageAsync(
    @StringRes contentDescRes: Int,
    modifier: Modifier = Modifier,
    url: String = "",
    @DrawableRes imageRes: Int? = null,
    isLoading: Boolean = false,
) {
    var isFetchingImage by remember { mutableStateOf(true) }
    AsyncImage(
        model = if (imageRes != null) painterResource(id = imageRes) else url,
        contentDescription = stringResource(id = contentDescRes),
        modifier = modifier
            .clip(PodcastAppTheme.shapes.mediumCornerShape)
            .shimmerEffect(isLoading || isFetchingImage),
        onSuccess = { isFetchingImage = false }
    )
}