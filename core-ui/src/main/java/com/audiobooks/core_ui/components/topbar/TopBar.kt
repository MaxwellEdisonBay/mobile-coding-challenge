package com.audiobooks.core_ui.components.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.audiobooks.core_ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBarWithBackNavigation(
    title: String,
    config: TopAppBarConfig,
    onBackPressed: () -> Unit
) {
    TopAppBar(
        title = {
            if (config.isLargeTitle) {
                Text(text = title)
            }
        },
        navigationIcon = {
            if (config.isBackVisible) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            contentDescription = stringResource(id = R.string.core_ui_top_nav_back_icon_alt)
                        )
                    }
//                Spacer(modifier = Modifier.width(PodcastAppTheme.dimensions.paddingSmall))
                    Text(text = stringResource(id = R.string.core_ui_top_nav_back_text))
                }
            }
        }
    )
}

data class TopAppBarConfig(
    val isLargeTitle: Boolean = false,
    val isBackVisible: Boolean = true,
)