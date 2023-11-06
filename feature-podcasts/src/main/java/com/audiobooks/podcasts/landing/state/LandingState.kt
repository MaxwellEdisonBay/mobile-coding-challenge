package com.audiobooks.podcasts.landing.state

import com.audiobooks.core.domain.Podcast

internal data class LandingState(
    val isLoading: Boolean = false,
    val podcasts: List<Podcast> = emptyList(),
    val paginationOffset: Int = 0,
    val endReached: Boolean = false,
    val error: String = ""
)
