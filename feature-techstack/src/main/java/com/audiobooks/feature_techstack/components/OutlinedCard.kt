package com.audiobooks.feature_techstack.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.audiobooks.core_ui.theme.PodcastAppTheme

/**
 * Outline card component
 *
 */
@Composable
fun CustomOutlinedCard() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = PodcastAppTheme.colors.background,
        ),
        border = BorderStroke(1.dp, PodcastAppTheme.colors.primary),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Outlined",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
            Text(
                text = "Outlined",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}