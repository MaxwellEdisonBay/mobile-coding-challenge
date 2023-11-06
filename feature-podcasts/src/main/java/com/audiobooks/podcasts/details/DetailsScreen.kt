package com.audiobooks.podcasts.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.RoundedImageAsync
import com.audiobooks.core_ui.components.text.HtmlText
import com.audiobooks.dashboard.R
import com.audiobooks.podcasts.SharedViewModel

@Composable
internal fun DetailsScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state = viewModel.detailsState.value
    val podcast = sharedViewModel.selectedPodcast
    BaseScaffold(navController = navController) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            podcast?.let {
                Text(text = podcast.title)
                Text(text = podcast.publisher)
                RoundedImageAsync(
                    url = podcast.largeImageUrl,
                    contentDescRes = R.string.feature_podcast_details_large_image_alt
                )
                HtmlText(html = podcast.description)
            }
        }
    }
}