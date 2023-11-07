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
}