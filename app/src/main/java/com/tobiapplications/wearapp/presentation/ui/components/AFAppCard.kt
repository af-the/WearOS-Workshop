package com.tobiapplications.wearapp.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Text
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.material.Icon
import com.google.android.horologist.images.base.paintable.PaintableIcon

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun AFAppCard(
    icon: PaintableIcon,
    appName: String,
    time: String,
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    AppCard(
        modifier = modifier,
        appImage = {
            Icon(
                paintable = icon,
                contentDescription = null,
                modifier = Modifier
            )
        },
        appName = { Text(appName) },
        time = { Text(time) },
        title = { Text(title) },
        onClick = onClick
    ) {
        Text(text)
    }
}
