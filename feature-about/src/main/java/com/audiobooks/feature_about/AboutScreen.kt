package com.audiobooks.feature_about

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.topbar.TopAppBarConfig

@Composable
internal fun AboutScreen(navController: NavController) {
    BaseScaffold(
        title = stringResource(id = R.string.feature_about_screen_title),
        navController = navController,
        topAppBarConfig = TopAppBarConfig(isLargeTitle = true)
    ) {
        AboutContent()
//        Text(text = "About Content")
    }
}

@Composable
private fun AboutContent(){
    val url = stringResource(id = R.string.feature_about_screen_linkedin_url)
    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}