package com.audiobooks.networking.repository

import com.audiobooks.core.domain.PodcastsPage
import com.audiobooks.networking.BuildConfig
import com.audiobooks.networking.PodcastsApi
import com.audiobooks.networking.util.Resource
import com.audiobooks.networking.util.toPage
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PodcastsRepositoryImpl @Inject constructor(
    private val podcastsApi: PodcastsApi
): PodcastsRepository {
    override fun getPodcasts(offset: Int): Flow<Resource<PodcastsPage>> = flow {
        try {
            emit(Resource.Loading())
            val page = podcastsApi.getPodcasts(offset).toPage()
            // Slow down the API to show shimmer loading in debug.
            if (BuildConfig.DEBUG) {
                delay(1000)
            }
            emit(Resource.Success(page))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}