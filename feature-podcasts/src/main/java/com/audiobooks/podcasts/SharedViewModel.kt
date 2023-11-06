package com.audiobooks.podcasts

import androidx.lifecycle.ViewModel
import com.audiobooks.core.domain.Podcast
import javax.inject.Inject

class SharedViewModel @Inject constructor(

) : ViewModel() {
    internal var selectedPodcast : Podcast? = null
}