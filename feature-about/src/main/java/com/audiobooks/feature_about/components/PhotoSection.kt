package com.audiobooks.feature_about.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.audiobooks.core_ui.components.CircleImage
import com.audiobooks.core_ui.theme.PodcastAppTheme
import com.audiobooks.feature_about.R

/**
 * Photo section on top of the About page
 */
@Composable
internal fun PhotoSection() {
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = PodcastAppTheme.dimensions.paddingMedium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircleImage(
            imageRes = R.drawable.ivan_photo,
            imageAlt = R.string.feature_about_screen_ivan_photo_alt_text,
            modifier = Modifier
                .size(PodcastAppTheme.dimensions.cardImageMedium)
        )
        Column() {
            val linkedInUri = stringResource(id = R.string.feature_about_screen_linkedin_url)
            val githubUri = stringResource(id = R.string.feature_about_screen_github_url)
            val emailUri = stringResource(id = R.string.feature_about_screen_email)
            SocialLink(
                iconRes = R.drawable.linkedin_icon,
                textRes = R.string.feature_about_screen_social_linkedin,
                tint = Color.Blue
            ) {
                uriHandler.openUri(linkedInUri)
            }
            Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingBigger))
            SocialLink(
                iconRes = R.drawable.github_icon,
                textRes = R.string.feature_about_screen_social_github
            ) {
                uriHandler.openUri(githubUri)
            }
            Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingBigger))
            SocialLink(
                iconRes = R.drawable.email_icon,
                textRes = R.string.feature_about_screen_social_email,
                tint = PodcastAppTheme.colors.primary
            ) {
                uriHandler.openUri(emailUri)
            }
        }
    }
    Text(
        text = stringResource(id = R.string.feature_about_screen_bio_text),
        style = PodcastAppTheme.typography.body
    )
    Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingLarge))
    Divider()
//    Spacer(modifier = Modifier.height(PodcastAppTheme.dimensions.paddingLarge))

}