package com.audiobooks.podcasts.landing.state

import com.audiobooks.core.domain.Podcast

/**
 * Landing Screen UI state data class
 *
 * @property isLoading is page loading
 * @property podcasts podcasts list to display
 * @property paginationOffset current pagination offset
 * @property endReached is infinite scroll end reached
 * @property error is error
 */
internal data class LandingState(
    val isLoading: Boolean = false,
    val podcasts: List<Podcast> = emptyList(),
    val paginationOffset: Int = 0,
    val endReached: Boolean = false,
    val error: String = ""
)
