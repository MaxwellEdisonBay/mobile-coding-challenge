package com.audiobooks.podcasts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.audiobooks.core.domain.Podcast
import javax.inject.Inject

class SharedViewModel @Inject constructor(

) : ViewModel() {
    internal var favourite = mutableStateOf(emptyList<String>())
    internal var selectedPodcast : Podcast? = null

    internal fun addToFavourite(id: String) {
        favourite.value = favourite.value + listOf(id)
    }

    internal fun removeFromFavourite(id: String) {
        favourite.value = favourite.value.filter { it != id }
    }

    internal fun isFavourite(id: String) = favourite.value.contains(id)
}