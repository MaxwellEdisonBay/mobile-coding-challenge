package com.audiobooks.core.domain

data class Podcast(
    val id: String,
    val title: String,
    val publisher: String,
    val thumbnailUrl: String,
    val largeImageUrl: String,
    val description: String,
)
