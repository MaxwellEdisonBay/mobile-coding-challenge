package com.audiobooks.podcastapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.podcastapp.navigation.MainScreen
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main Activity for the single-activity app
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PodcastAppTheme {
                MainScreen()
            }
        }
    }
}