package com.audiobooks.podcasts.utils

import androidx.compose.runtime.MutableState

/**
 * Add podcast with [id] to favourites
 *
 * @param id podcast id
 */
internal fun MutableState<List<String>>.addToFavourites(id: String) {
    this.value = this.value + listOf(id)
}

/**
 * Remove podcast with [id] from favourites
 *
 * @param id podcast id
 */
internal fun MutableState<List<String>>.removeFromFavourites(id: String) {
    this.value = this.value.filter { it != id }
}

/**
 * Check if a podcast with [id] is in favourites
 *
 * @param id podcast id
 *
 * @return boolean value
 */
internal fun MutableState<List<String>>.isFavourite(id: String): Boolean = this.value.contains(id)