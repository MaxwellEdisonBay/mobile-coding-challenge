package com.audiobooks.networking.repository

import com.audiobooks.core.domain.PodcastsPage
import com.audiobooks.networking.util.Resource
import kotlinx.coroutines.flow.Flow

interface PodcastsRepository {
    fun getPodcasts(offset: Int): Flow<Resource<PodcastsPage>>
}