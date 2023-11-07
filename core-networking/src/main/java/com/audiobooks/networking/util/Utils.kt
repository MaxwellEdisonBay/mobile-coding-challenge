package com.audiobooks.networking.util

import com.audiobooks.core.domain.Podcast
import com.audiobooks.core.domain.PodcastsPage
import com.audiobooks.networking.BuildConfig
import com.audiobooks.networking.dto.PodcastsListRs
import java.util.UUID

/**
 * Converts PodcastsListRs DTO object to domain
 *
 * @return [PodcastsPage] instance
 */
internal fun PodcastsListRs.toPage(): PodcastsPage {
    return PodcastsPage(
        nextOffset = nextOffset ?: 0,
        podcasts = results.map {
            Podcast(
                // Mock API gives the same data. It's needed to achieve unique podcast IDs in debug.
                id = if (BuildConfig.DEBUG) {
                    UUID.randomUUID().toString()
                } else {
                    it.id.orEmpty()
                },
                title = it.titleOriginal.orEmpty(),
                publisher = it.podcastRs?.publisherOriginal.orEmpty(),
                thumbnailUrl = it.thumbnail.orEmpty(),
                largeImageUrl = it.image.orEmpty(),
                description = it.descriptionOriginal.orEmpty()
            )
        }
    )
}