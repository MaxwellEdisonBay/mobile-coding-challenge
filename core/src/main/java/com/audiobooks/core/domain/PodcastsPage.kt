package com.audiobooks.core.domain

data class PodcastsPage (
    val podcasts: List<Podcast>,
    val nextOffset: Int
)