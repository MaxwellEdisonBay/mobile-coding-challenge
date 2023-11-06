package com.audiobooks.podcasts.landing

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core.domain.Podcast
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.card.MediumListImageCard
import com.audiobooks.core_ui.components.list.InfiniteListHandler
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.podcasts.landing.components.podcastListSkeletonLoader

@Composable
internal fun LandingScreen(
    navController: NavController,
    viewModel: LandingViewModel = hiltViewModel(),
) {
    val state = viewModel.landingState.collectAsState()

    LandingScreenContent(
        navController = navController,
        isLoading = state.value.isLoading,
        podcasts = state.value.podcasts,
        onInitialLoad = {
            viewModel.getPodcasts()
        },
        onPaginationLoad = {
            viewModel.getPodcastsWithPagination()
        }
    )
}

@Composable
private fun LandingScreenContent(
    navController: NavController,
    isLoading: Boolean,
    podcasts: List<Podcast>,
    onInitialLoad: () -> Unit,
    onPaginationLoad: () -> Unit
) {
    val isPaginationLoading = isLoading && podcasts.isNotEmpty()
    val isInitialLoading = isLoading && podcasts.isEmpty()
    val lazyListState = rememberLazyListState()

    BaseScaffold(navController = navController) {
        Column {
            LazyColumn(state = lazyListState) {
                if (isInitialLoading) {
                    onInitialLoad()
                } else {
                    items(podcasts) {
                        MediumListImageCard(
                            title = it.title,
                            subTitle = it.publisher,
                            imageUrl = it.thumbnailUrl
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
            onPaginationLoad = {}
        )
    }
}