package com.audiobooks.core_ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun CircleImage(
    @DrawableRes imageRes: Int,
    @StringRes imageAlt: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.clip(CircleShape),
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(id = imageAlt)
    )
}