package com.audiobooks.feature_techstack.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import com.audiobooks.core_ui.components.card.RoundImageCard
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.feature_techstack.R
import com.audiobooks.feature_techstack.domain.Tech

/**
 * Technologies List component
 *
 */
@Composable
internal fun TechsList() {
    val images = remember {
        listOf(
            R.drawable.android_icon,
            R.drawable.kotlin_icon,
            R.drawable.gradle_icon,
            R.drawable.compose_icon,
            R.drawable.hilt_logo,
            R.drawable.retrofit_logo,
            R.drawable.coil_logo_black
        )
    }
    val techAlts = stringArrayResource(id = R.array.feature_techstack_screen_image_alts)
    val techTitles = stringArrayResource(id = R.array.feature_techstack_screen_titles)
    val techDescs = stringArrayResource(id = R.array.feature_techstack_screen_descs)
    val items = images.mapIndexed { index, image ->
        Tech(image, techAlts[index], techTitles[index], techDescs[index])
    }

    items.forEach {
        it.apply { RoundImageCard(imageRes, imageAlt, title, desc) }
        Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingMedium))
    }
}