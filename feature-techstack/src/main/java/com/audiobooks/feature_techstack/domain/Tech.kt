package com.audiobooks.feature_techstack.domain

import androidx.annotation.DrawableRes

/**
 * Tech row data for UI
 *
 * @property imageRes tech logo resource
 * @property imageAlt logo content desc resource
 * @property title title resource
 * @property desc desc resource
 */
data class Tech(
    @DrawableRes val imageRes: Int,
    val imageAlt: String,
    val title: String,
    val desc: String,
)
