package com.audiobooks.podcasts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.audiobooks.core.domain.Podcast
import javax.inject.Inject

/**
 * Viewmodel to store shared data between Podcasts pages.
 * It's attached to podcasts nav graph lifecycle.
 *
 */
internal class SharedViewModel @Inject constructor(

) : ViewModel() {
    internal var favourite = mutableStateOf(emptyList<String>())
    internal var selectedPodcast : Podcast? = null

    /**
     * Add podcast with [id] to favourites
     *
     * @param id podcast id
     */
    internal fun addToFavourites(id: String) {
        favourite.value = favourite.value + listOf(id)
    }

    /**
     * Remove podcast with [id] from favourites
     *
     * @param id podcast id
     */
    internal fun removeFromFavourites(id: String) {
        favourite.value = favourite.value.filter { it != id }
    }

    /**
     * Check if a podcast with [id] is in favourites
     *
     * @param id podcast id
     *
     * @return boolean value
     */
    internal fun isFavourite(id: String): Boolean = favourite.value.contains(id)
}