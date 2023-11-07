package com.audiobooks.podcasts.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.audiobooks.podcasts.details.state.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Details Screen view model example
 *
 */
@HiltViewModel
internal class DetailsViewModel @Inject constructor(): ViewModel() {
    private val _detailsState = mutableStateOf(DetailsState())
    internal val detailsState: State<DetailsState> = _detailsState
}