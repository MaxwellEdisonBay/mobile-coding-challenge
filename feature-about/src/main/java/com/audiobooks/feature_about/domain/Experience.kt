package com.audiobooks.feature_about.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.audiobooks.feature_about.R

internal data class Experience(
    @DrawableRes val imageRes: Int = R.drawable.td_logo,
    @StringRes val imageAlt: Int = R.string.feature_about_screen_logo_td_alt_text,
    @StringRes val title: Int = R.string.feature_about_screen_td_title_text,
    @StringRes val employer: Int = R.string.feature_about_screen_td_employer_text,
    @StringRes val dates: Int = R.string.feature_about_screen_td_dates_text,
    @StringRes val location: Int = R.string.feature_about_screen_td_location_text,
    @StringRes val desc: Int = R.string.feature_about_screen_td_desc_text
)
