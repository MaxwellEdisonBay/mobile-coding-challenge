package com.audiobooks.podcasts.landing

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.audiobooks.networking.repository.PodcastsRepository
import com.audiobooks.podcasts.landing.state.LandingState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LandingViewModel @Inject constructor(
    private val podcastsRepository: PodcastsRepository,
): ViewModel() {
    private val _landingState = mutableStateOf(LandingState())
    internal val landingState: State<LandingState> = _landingState
}