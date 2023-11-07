package com.audiobooks.networking

import com.audiobooks.networking.dto.PodcastsListRs
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface for podcasts api
 *
 */
interface PodcastsApi {

    @GET("v2/search?q=startup")
    suspend fun getPodcasts(
        @Query("offset") offset: Int = 0
    ): PodcastsListRs
}