package com.audiobooks.feature_about.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.feature_about.R
import com.audiobooks.feature_about.domain.Experience

@Composable
internal fun ColumnScope.ExperienceSection() {
    val experiences = remember {
        listOf(
            Experience(
                imageRes = R.drawable.td_logo,
                imageAlt = R.string.feature_about_screen_logo_td_alt_text,
                title = R.string.feature_about_screen_td_title_text,
                employer = R.string.feature_about_screen_td_employer_text,
                dates = R.string.feature_about_screen_td_dates_text,
                location = R.string.feature_about_screen_td_location_text,
                desc = R.string.feature_about_screen_td_desc_text
            ),
            Experience(
                imageRes = R.drawable.cleverlance_logo,
                imageAlt = R.string.feature_about_screen_logo_cleverlance_alt_text,
                title = R.string.feature_about_screen_cleverlance_title_text,
                employer = R.string.feature_about_screen_cleverlance_employer_text,
                dates = R.string.feature_about_screen_cleverlance_dates_text,
                location = R.string.feature_about_screen_cleverlance_location_text,
                desc = R.string.feature_about_screen_cleverlance_desc_text
            ),
            Experience(
                imageRes = R.drawable.megaknihy_logo,
                imageAlt = R.string.feature_about_screen_logo_megaknihy_alt_text,
                title = R.string.feature_about_screen_megaknihy_title_text,
                employer = R.string.feature_about_screen_megaknihy_employer_text,
                dates = R.string.feature_about_screen_megaknihy_dates_text,
                location = R.string.feature_about_screen_megaknihy_location_text,
                desc = R.string.feature_about_screen_megaknihy_desc_text
            )
        )
    }
    Text(
        text = stringResource(id = R.string.feature_about_screen_experience_section_title),
        style = PodcastAppTheme.typography.h1,
        modifier = Modifier.padding(
            top = PodcastAppTheme.dimensions.paddingLarge,
            bottom = PodcastAppTheme.dimensions.paddingMedium
        )
    )
    experiences.forEach {
        it.apply {
            ExperienceCard(
                imageRes,
                imageAlt,
                title,
                employer,
                dates,
                location,
                desc
            )
        }
        Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
    }
}