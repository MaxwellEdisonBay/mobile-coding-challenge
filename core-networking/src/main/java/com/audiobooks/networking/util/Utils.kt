package com.audiobooks.networking.util

import com.audiobooks.core.domain.Podcast
import com.audiobooks.core.domain.PodcastsPage
import com.audiobooks.networking.dto.PodcastsListRs

internal fun PodcastsListRs.toPage(): PodcastsPage {
    return PodcastsPage(
        nextOffset = nextOffset ?: 0,
        podcasts = results.map {
            Podcast(
                id = it.id.orEmpty(),
                title = it.titleOriginal.orEmpty(),
                publisher = it.podcastRs?.publisherOriginal.orEmpty(),
                thumbnailUrl = it.thumbnail.orEmpty(),
                largeImageUrl = it.image.orEmpty(),
                description = it.descriptionOriginal.orEmpty()
            )
        }
    )
}