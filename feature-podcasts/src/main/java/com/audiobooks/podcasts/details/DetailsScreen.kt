package com.audiobooks.podcasts.details

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.audiobooks.core_ui.util.objectSlideInVerticallyTransition
import com.audiobooks.podcasts.R
import com.audiobooks.podcasts.SharedViewModel
import com.audiobooks.podcasts.details.components.FavouriteButton
import com.audiobooks.podcasts.utils.addToFavourites
import com.audiobooks.podcasts.utils.isFavourite
import com.audiobooks.podcasts.utils.removeFromFavourites

/**
 * Details Screen composable
 *
 * @param navController used for navigation
 * @param sharedViewModel vm for shared data between podcasts screens
 * @param viewModel vm for local screen data
 */
@Composable
internal fun DetailsScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    // TODO: Implement state in the screen in future
    val state = viewModel.detailsState.value
    val podcast = sharedViewModel.selectedPodcast
    val id = podcast?.id.orEmpty()
    val favourite = remember { sharedViewModel.favourite }
    val isFavourite = favourite.isFavourite(id)

    DetailsScreenContent(
        navController = navController,
        podcast = podcast,
        isFavourite = isFavourite,
        onFavouriteClick = {
            if (isFavourite) {
                favourite.removeFromFavourites(id)
            } else {
                favourite.addToFavourites(id)
            }
        })
}

/**
 * Details Screen UI composable. It's used for better preview experience.
 *
 * @param navController navigation
 * @param podcast current selected [Podcast]
 * @param isFavourite is favourite state
 * @param onFavouriteClick on favourite button click
 */
@Composable
private fun DetailsScreenContent(
    navController: NavController,
    podcast: Podcast?,
    isFavourite: Boolean = false,
    onFavouriteClick: () -> Unit = {}
) {
    var isBottomAnimVisible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        isBottomAnimVisible = true
    }
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
                AnimatedVisibility(
                    visible = isBottomAnimVisible,
                    enter = objectSlideInVerticallyTransition
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        FavouriteButton(
                            favourite = isFavourite,
                            onClick = {
                                onFavouriteClick()
                            }
                        )
                        Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
                        HtmlText(html = podcast.description)
                    }
                }
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