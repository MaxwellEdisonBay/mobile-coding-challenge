package com.audiobooks.feature_about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.topbar.TopAppBarConfig
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.feature_about.components.ExperienceCard
import com.audiobooks.feature_about.components.ExperienceSection
import com.audiobooks.feature_about.components.PhotoSection
import com.audiobooks.feature_about.domain.Experience

/**
 * About Screen
 *
 * @param navController used for navigation
 */
@Composable
internal fun AboutScreen(navController: NavController) {
    BaseScaffold(
        title = stringResource(id = R.string.feature_about_screen_title),
        navController = navController,
        topAppBarConfig = TopAppBarConfig(isLargeTitle = true)
    ) {
        AboutContent()
    }
}

/**
 * About screen content UI
 * Used for better preview experience
 */
@Composable
private fun AboutContent() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        PhotoSection()
        ExperienceSection()
    }
}

@Composable
@Preview
private fun AboutScreenPreview() {
    PodcastAppTheme {
        AboutScreen(navController = rememberNavController())
    }
}