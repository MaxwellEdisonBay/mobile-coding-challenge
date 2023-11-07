package com.audiobooks.core_ui.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.audiobooks.core_ui.R
import com.audiobooks.core_ui.theme.PodcastAppTheme

@Composable
fun SmallListImageCard(
    modifier: Modifier = Modifier,
    image: @Composable () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(PodcastAppTheme.colors.background),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        image()
        Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingMedium))
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
        ) {
            content()
        }
    }
}


@Preview
@Composable
fun SmallListImageCardPreview() {
    SmallListImageCard(image = {
        Image(painter = painterResource(id = R.drawable.placeholder), contentDescription = null)
    }) {
        Text(text = "Test")
    }
}
