package com.audiobooks.core_ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import com.audiobooks.core_ui.components.topbar.TopAppBarConfig
import com.audiobooks.core_ui.components.topbar.TopBarWithBackNavigation
import com.audiobooks.core_ui.theme.PodcastAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    title: String = "",
    topAppBarConfig: TopAppBarConfig = TopAppBarConfig(),
    content: @Composable () -> Unit
) {
//    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        topBar = {
            TopBarWithBackNavigation(
                title = title,
                config = topAppBarConfig,
                scrollBehavior = scrollBehavior,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        },
        containerColor = PodcastAppTheme.colors.background,
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = PodcastAppTheme.dimensions.pageContentPadding)
        ) {
            content()
        }
    }
}