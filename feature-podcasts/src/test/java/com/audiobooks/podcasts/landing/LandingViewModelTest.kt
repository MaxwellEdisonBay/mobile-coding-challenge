package com.audiobooks.podcasts.landing

import com.audiobooks.core.domain.Podcast
import com.audiobooks.core.domain.PodcastsPage
import com.audiobooks.networking.repository.PodcastsRepository
import com.audiobooks.podcasts.MainDispatcherRule
import io.mockk.InternalPlatformDsl.toArray
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Landing ViewModel unit test
 *
 */
class LandingViewModelTest {

    private lateinit var repository: PodcastsRepository
    private lateinit var viewModel: LandingViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup() {
        repository = mockk(relaxed = true)
        viewModel = LandingViewModel(repository)
    }

    /**
     * Testing [LandingViewModel.onRequestLoading] functionality
     *
     */
    @Test
    fun `onRequestLoading should start loading`() {
        viewModel.onRequestLoading()
        assertTrue(viewModel.landingState.value.isLoading)
    }

    /**
     * Testing [LandingViewModel.onRequestError] functionality
     *
     */
    @Test
    fun `onRequestError should stop loading`() {
        viewModel.onRequestError("ErrorMsg")
        assertFalse(viewModel.landingState.value.isLoading)
    }

    @Test
    fun `onRequestError should set an error`() {
        val errorMsg = "ErrorMsg"
        viewModel.onRequestError(errorMsg)
        assertEquals(viewModel.landingState.value.error, errorMsg)
    }

    /**
     * Testing [LandingViewModel.onRequestSuccess] functionality
     *
     */
    @Test
    fun `onRequestSuccess should stop loading`() {
        viewModel.onRequestSuccess(PodcastsPage(emptyList(), 1))
        assertFalse(viewModel.landingState.value.isLoading)
    }

    @Test
    fun `onRequestSuccess should update podcasts`() {
        val addedPodcasts = listOf(Podcast(), Podcast())
        val initSize = viewModel.landingState.value.podcasts.size
        viewModel.onRequestSuccess(PodcastsPage(addedPodcasts, 1))
        assertEquals(initSize + addedPodcasts.size, viewModel.landingState.value.podcasts.size)
    }

    @Test
    fun `onRequestSuccess should set endReached if page data is empty`() {
        viewModel.onRequestSuccess(PodcastsPage(emptyList(), 1))
        assertTrue(viewModel.landingState.value.endReached)
    }

    @Test
    fun `onRequestSuccess should set endReached if page data is more than max value`() {
        val myArrayList = ArrayList<Podcast>()
        repeat(MAX_PODCASTS_LOADED + 1) {
            myArrayList.add(Podcast())
        }
        viewModel.updateState(podcasts = myArrayList)
        viewModel.onRequestSuccess(PodcastsPage(myArrayList, 1))
        assertTrue(viewModel.landingState.value.endReached)
    }
}