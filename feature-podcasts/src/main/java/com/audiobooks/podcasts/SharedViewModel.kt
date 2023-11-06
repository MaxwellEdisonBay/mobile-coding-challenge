package com.audiobooks.podcasts

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.audiobooks.core.domain.Podcast
import javax.inject.Inject

class SharedViewModel @Inject constructor(

) : ViewModel() {
    internal var favourite = mutableStateOf(emptyList<String>())
    internal var selectedPodcast : Podcast? = null
}