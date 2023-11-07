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

/**
 * Circle image component. Used for user avatars
 *
 * [imageRes] image drawable resource
 * [modifier] modifier
 * [imageAlt] image content description resource
 * [imageAltStr] image content description string
 */
@Composable
fun CircleImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    @StringRes imageAlt: Int = -1,
    imageAltStr: String = "",
) {
    Image(
        modifier = modifier.clip(CircleShape),
        painter = painterResource(id = imageRes),
        contentDescription = imageAltStr.ifBlank { stringResource(id = imageAlt) }
    )
}