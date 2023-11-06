package com.audiobooks.podcasts.landing

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.audiobooks.core.domain.PodcastsPage
import com.audiobooks.networking.repository.PodcastsRepository
import com.audiobooks.networking.util.Resource
import com.audiobooks.podcasts.landing.state.LandingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.plus
import javax.inject.Inject

private const val MAX_PODCASTS_LOADED = 200

@HiltViewModel
internal class LandingViewModel @Inject constructor(
    private val podcastsRepository: PodcastsRepository,
) : ViewModel() {
    private val _landingState = MutableStateFlow(LandingState())
    internal val landingState = _landingState.asStateFlow()
    init {
        if (_landingState.value.podcasts.isEmpty()) {
            getPodcasts(0)
        }
    }

    internal fun getPodcasts(offset: Int = 0) {
        podcastsRepository.getPodcasts(offset)
            .distinctUntilChanged()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> result.data?.let { data -> onRequestSuccess(data) }
                    is Resource.Error -> onRequestError(result.message)
                    is Resource.Loading -> onRequestLoading()
                    else -> Unit
                }
            }
            .launchIn(viewModelScope + SupervisorJob())
    }

    internal fun getPodcastsWithPagination() {
        if (_landingState.value.podcasts.isNotEmpty()
            && !_landingState.value.endReached
        ) {
            Log.d("TEST", "Fetching with pagination")
            getPodcasts(_landingState.value.paginationOffset)
        }
    }

    private fun onRequestSuccess(data: PodcastsPage) {
        _landingState.update {
            it.copy(
                podcasts = it.podcasts + data.podcasts,
                isLoading = false,
                error = "",
                paginationOffset = data.nextOffset,
                endReached = data.podcasts.isEmpty() || it.podcasts.size >= MAX_PODCASTS_LOADED
            )
        }
    }

    private fun onRequestError(message: String?) {
        _landingState.update {
            it.copy(
                error = message ?: "Unexpected Error",
                isLoading = false,
            )
        }
    }

    private fun onRequestLoading() {
        _landingState.update {
            it.copy(
                isLoading = true
            )
        }
    }
}