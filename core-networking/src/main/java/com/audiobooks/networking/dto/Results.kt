package com.audiobooks.networking.dto

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") var id: String? = null,
    @SerializedName("rss") var rss: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("audio") var audio: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("podcast") var podcastRs: PodcastRs? = PodcastRs(),
    @SerializedName("itunes_id") var itunesId: Int? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("pub_date_ms") var pubDateMs: Long? = null,
    @SerializedName("guid_from_rss") var guidFromRss: String? = null,
    @SerializedName("title_original") var titleOriginal: String? = null,
    @SerializedName("listennotes_url") var listennotesUrl: String? = null,
    @SerializedName("audio_length_sec") var audioLengthSec: Int? = null,
    @SerializedName("explicit_content") var explicitContent: Boolean? = null,
    @SerializedName("title_highlighted") var titleHighlighted: String? = null,
    @SerializedName("description_original") var descriptionOriginal: String? = null,
    @SerializedName("description_highlighted") var descriptionHighlighted: String? = null,
    @SerializedName("transcripts_highlighted") var transcriptsHighlighted: ArrayList<String> = arrayListOf()
)