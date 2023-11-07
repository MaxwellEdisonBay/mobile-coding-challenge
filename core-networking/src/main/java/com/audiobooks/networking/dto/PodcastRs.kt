package com.audiobooks.networking.dto

import com.google.gson.annotations.SerializedName

/**
 * Podcasts DTO generated from Api JSON response
 *
 */
data class PodcastRs(
    @SerializedName("id") var id: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("genre_ids") var genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("listen_score") var listenScore: Int? = null,
    @SerializedName("title_original") var titleOriginal: String? = null,
    @SerializedName("listennotes_url") var listennotesUrl: String? = null,
    @SerializedName("title_highlighted") var titleHighlighted: String? = null,
    @SerializedName("publisher_original") var publisherOriginal: String? = null,
    @SerializedName("publisher_highlighted") var publisherHighlighted: String? = null,
    @SerializedName("listen_score_global_rank") var listenScoreGlobalRank: String? = null
)