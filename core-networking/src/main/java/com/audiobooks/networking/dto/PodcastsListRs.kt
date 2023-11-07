package com.audiobooks.networking.dto

import com.google.gson.annotations.SerializedName

/**
 * Podcasts List DTO generated from Api JSON response
 *
 */
data class PodcastsListRs(
    @SerializedName("took") var took: Double? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("next_offset") var nextOffset: Int? = null
)
