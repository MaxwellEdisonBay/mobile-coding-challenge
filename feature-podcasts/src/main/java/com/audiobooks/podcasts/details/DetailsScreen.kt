package com.audiobooks.podcasts.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core.domain.Podcast
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.RoundedImageAsync
import com.audiobooks.core_ui.components.text.HtmlText
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.podcasts.R
import com.audiobooks.podcasts.SharedViewModel
import com.audiobooks.podcasts.details.components.FavouriteButton

@Composable
internal fun DetailsScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state = viewModel.detailsState.value
    val podcast = sharedViewModel.selectedPodcast
    val id = podcast?.id.orEmpty()
    val favourite = remember { sharedViewModel.favourite }
    val isFavourite = sharedViewModel.isFavourite(id)

    DetailsScreenContent(
        navController = navController,
        podcast = podcast,
        isFavourite = isFavourite,
        onFavouriteClick = {
            if (isFavourite) {
                sharedViewModel.removeFromFavourite(id)
//                favourite.remove(id)
            } else {
//                favourite.add(id)
                sharedViewModel.addToFavourite(id)
            }
        })
}

@Composable
private fun DetailsScreenContent(
    navController: NavController,
    podcast: Podcast?,
    isFavourite: Boolean = false,
    onFavouriteClick: () -> Unit = {}
) {
    BaseScaffold(navController = navController) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            podcast?.let {
                Text(
                    text = podcast.title,
                    style = PodcastAppTheme.typography.h1,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = podcast.publisher,
                    style = PodcastAppTheme.typography.subtitle,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
                RoundedImageAsync(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    url = podcast.largeImageUrl,
                    contentDescRes = R.string.feature_podcast_details_large_image_alt
                )
                Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
                FavouriteButton(favourite = isFavourite, onClick = {
                    onFavouriteClick()
                })
                Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
                HtmlText(html = podcast.description)
            }
        }
    }
}

@Composable
@Preview
fun DetailsScreenPreview() {
    DetailsScreenContent(
        navController = rememberNavController(),
        podcast = Podcast("", "Title", "Publisher", "", "", "Description")
    )
}