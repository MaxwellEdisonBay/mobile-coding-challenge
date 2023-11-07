package com.audiobooks.core.domain

/**
 * Podcasts pagination object
 *
 * @property podcasts list of podcasts in the page
 * @property nextOffset next offset for pagination
 */
data class PodcastsPage (
    val podcasts: List<Podcast>,
    val nextOffset: Int
)