package com.audiobooks.podcasts.utils

import androidx.compose.runtime.MutableState

internal fun MutableState<List<String>>.addToFavourites(id: String) {
    this.value = this.value + listOf(id)
}
internal fun MutableState<List<String>>.removeFromFavourites(id: String) {
    this.value = this.value.filter { it != id }
}
internal fun MutableState<List<String>>.isFavourite(id: String): Boolean = this.value.contains(id)