package com.audiobooks.podcasts.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.RoundedImageAsync
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
        podcast?.let {
            Text(text = podcast.title)
            Text(text = podcast.publisher)
            RoundedImageAsync(
                url = podcast.largeImageUrl,
                contentDescRes = R.string.feature_podcast_details_large_image_alt
            )
            Text(text = podcast.description)
        }
    }
}