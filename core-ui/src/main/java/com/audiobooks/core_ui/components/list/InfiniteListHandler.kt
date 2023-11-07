package com.audiobooks.core_ui.components.list

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.audiobooks.core.NUMBER_OF_PODCASTS_LOADED
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Infinite scroll loading handler.
 *
 * [lazyListState] state of the attached lazy list
 * [buffer] how many items "ahead" before the end of list
 * [onLoadMore] lambda when load more is triggered
 */
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