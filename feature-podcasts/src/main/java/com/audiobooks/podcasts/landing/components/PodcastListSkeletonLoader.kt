package com.audiobooks.podcasts.landing.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import com.audiobooks.core_ui.components.card.MediumListImageCard
import com.audiobooks.core_ui.theme.PodcastAppTheme

private const val NUMBER_OF_SKELETON_CARDS = 3

/**
 * Podcast skeleton loader state component
 *
 */
internal fun LazyListScope.podcastListSkeletonLoader() {
    items(NUMBER_OF_SKELETON_CARDS) {
        MediumListImageCard(isFavorite = true, isLoading = true)
        Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
    }
}