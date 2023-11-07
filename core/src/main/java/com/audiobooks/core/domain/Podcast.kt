package com.audiobooks.core.domain

/**
 * Used for Podcast data in UI
 *
 * @property id podcast id
 * @property title podcast title
 * @property publisher podcast publisher
 * @property thumbnailUrl podcast thumbnail (300x300) url
 * @property largeImageUrl podcast thumbnail (1400x1400) url
 * @property description podcast desc (with html markup)
 */
data class Podcast(
    val id: String = "",
    val title: String = "",
    val publisher: String = "",
    val thumbnailUrl: String = "",
    val largeImageUrl: String = "",
    val description: String = "",
)
