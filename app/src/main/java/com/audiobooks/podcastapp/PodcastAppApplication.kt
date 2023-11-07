package com.audiobooks.podcastapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Main app application. Used for Dagger-Hilt integration
 */
@HiltAndroidApp
class PodcastAppApplication : Application() {
}