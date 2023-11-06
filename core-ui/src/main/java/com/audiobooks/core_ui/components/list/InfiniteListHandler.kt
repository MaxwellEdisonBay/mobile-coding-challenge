package com.audiobooks.core_ui.components.list

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import com.audiobooks.core.NUMBER_OF_PODCASTS_LOADED
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun InfiniteListHandler(
    lazyListState: LazyListState,
    buffer: Int = 2,
    onLoadMore: () -> Unit
) {
    var prev by remember { mutableIntStateOf(lazyListState.layoutInfo.totalItemsCount) }
    val loadMore = remember {
        derivedStateOf {
            val layoutInfo = lazyListState.layoutInfo
            val totalItems = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1

            totalItems % NUMBER_OF_PODCASTS_LOADED == 0 && lastVisibleItemIndex > (totalItems - buffer)
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .distinctUntilChanged()
            .collect {
                if (it) {
                    prev = lazyListState.layoutInfo.totalItemsCount
                    onLoadMore()
                }
            }
    }
}