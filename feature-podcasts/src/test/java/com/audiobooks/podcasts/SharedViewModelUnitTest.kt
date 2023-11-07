package com.audiobooks.podcasts

import androidx.compose.runtime.mutableStateOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Shared ViewModel unit test
 *
 */
class SharedViewModelUnitTest {
    private val testId1 = "testId1"
    private val testId2 = "testId2"

    private lateinit var viewModel: SharedViewModel

    @Before
    fun setup() {
        viewModel = SharedViewModel()
    }

    /**
     * Testing [addToFavourites] functionality
     *
     */
    @Test
    fun `add to favourites is correct`() {
        viewModel.favourite = mutableStateOf(listOf(testId1))
        viewModel.addToFavourites(testId2)
        assertTrue(viewModel.favourite.value.contains(testId2))
        assertEquals(viewModel.favourite.value.size, 2)
    }

    /**
     * Testing [removeFromFavourites] functionality
     *
     */
    @Test
    fun `remove from favourites is correct`() {
        viewModel.favourite = mutableStateOf(listOf(testId1))
        viewModel.removeFromFavourites(testId1)
        assertTrue(viewModel.favourite.value.isEmpty())
    }

    /**
     * Testing [isFavourite] functionality
     *
     */
    @Test
    fun `is favourite is correct`() {
        viewModel.favourite = mutableStateOf(listOf(testId1, testId2))
        assertTrue(viewModel.isFavourite(testId1))
    }
}