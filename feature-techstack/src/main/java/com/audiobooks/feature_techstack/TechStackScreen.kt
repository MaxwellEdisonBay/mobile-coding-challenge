package com.audiobooks.feature_techstack

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.topbar.TopAppBarConfig
import com.audiobooks.feature_techstack.components.CustomOutlinedCard

/**
 * Tech Stack screen
 *
 * @param navController used for navigation
 */
@Composable
internal fun TechStackScreen(navController: NavController) {

    BaseScaffold(
        title = stringResource(id = R.string.feature_techstack_screen_title),
        navController = navController,
        topAppBarConfig = TopAppBarConfig(isLargeTitle = true)
    ) {
        CustomOutlinedCard()
    }
}

@Composable
@Preview
private fun TechStackScreenPreview() {
    TechStackScreen(navController = rememberNavController())
}