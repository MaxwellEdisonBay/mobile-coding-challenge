package com.audiobooks.podcasts.landing

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core.domain.Podcast
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.card.MediumListImageCard
import com.audiobooks.core_ui.components.list.InfiniteListHandler
import com.audiobooks.core_ui.components.topbar.TopAppBarConfig
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.podcasts.R
import com.audiobooks.podcasts.SharedViewModel
import com.audiobooks.podcasts.landing.components.podcastListSkeletonLoader
import com.audiobooks.podcasts.navigation.PodcastsRoutes
import com.audiobooks.podcasts.utils.isFavourite

/**
 * Landing Screen composable
 *
 * @param navController used for navigation
 * @param sharedViewModel vm to share data between screens
 * @param viewModel landing screen viewmodel
 */
@Composable
internal fun LandingScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: LandingViewModel = hiltViewModel(),
) {
    val state = viewModel.landingState.collectAsState()
    val favourite = remember { sharedViewModel.favourite }

    val isFavourite: (id: String) -> Boolean = {
        favourite.isFavourite(it)
    }

    LandingScreenContent(
        navController = navController,
        isLoading = state.value.isLoading,
        podcasts = state.value.podcasts,
        onInitialLoad = {
            viewModel.getPodcasts()
        },
        onPaginationLoad = {
            viewModel.getPodcastsWithPagination()
        },
        onPodcastItemClick = {
            sharedViewModel.selectedPodcast = it
            navController.navigate(PodcastsRoutes.Details.route)
        },
        isFavourite = isFavourite
    )
}

/**
 * Landing screen UI. Used for better Preview experience
 *
 * @param navController navigation
 * @param isLoading is loading
 * @param podcasts podcasts list
 * @param onInitialLoad on initial podcasts load lambda
 * @param onPaginationLoad on pagination podcasts load lambda
 * @param onPodcastItemClick on podcast item click lambda
 * @param isFavourite is podcast favourite lambda
 */
@Composable
private fun LandingScreenContent(
    navController: NavController,
    isLoading: Boolean,
    podcasts: List<Podcast>,
    onInitialLoad: () -> Unit,
    onPaginationLoad: () -> Unit,
    onPodcastItemClick: (Podcast) -> Unit,
    isFavourite: (id: String) -> Boolean
) {
    val isPaginationLoading = isLoading && podcasts.isNotEmpty()
    val isInitialLoading = isLoading && podcasts.isEmpty()
    val lazyListState = rememberLazyListState()

    BaseScaffold(
        navController = navController,
        title = stringResource(id = R.string.feature_podcast_landing_title),
        topAppBarConfig = TopAppBarConfig(isBackVisible = false, isLargeTitle = true)
    ) {
        LazyColumn(state = lazyListState) {
            if (isInitialLoading) {
                onInitialLoad()
            } else {
                items(podcasts) {
                    MediumListImageCard(
                        title = it.title,
                        subTitle = it.publisher,
                        imageUrl = it.thumbnailUrl,
                        isFavorite = isFavourite(it.id),
                        onClick = { onPodcastItemClick(it) }
                    )
                    Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
                }
            }
            if (isPaginationLoading) {
                podcastListSkeletonLoader()
            }
        }
        InfiniteListHandler(lazyListState = lazyListState) {
            onPaginationLoad()
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun LandingScreenContentPreview() {
    PodcastAppTheme {
        LandingScreenContent(
            navController = rememberNavController(),
            isLoading = true,
            podcasts = emptyList(),
            onInitialLoad = {},
            onPaginationLoad = {},
            onPodcastItemClick = {},
            isFavourite = { true }
        )
    }
}