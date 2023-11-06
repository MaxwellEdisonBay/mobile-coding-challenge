package com.audiobooks.podcasts.landing

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.audiobooks.core_ui.components.BaseScaffold
import com.audiobooks.core_ui.components.card.MediumListImageCard
import com.audiobooks.core_ui.components.list.InfiniteListHandler

@Composable
internal fun LandingScreen(
    navController: NavController,
    viewModel: LandingViewModel = hiltViewModel(),
) {
    val state = viewModel.landingState.collectAsState()
    val lazyListState = rememberLazyListState()

    BaseScaffold(navController = navController) {
        Column {
            LazyColumn(state = lazyListState) {
                items(state.value.podcasts) {
                    MediumListImageCard(
                        title = it.title,
                        subTitle = it.publisher,
                        imageUrl = it.thumbnailUrl
                    )
                }
            }
            InfiniteListHandler(lazyListState = lazyListState) {
                Log.d("TEST", "Loading new!")
            }
        }
    }
}