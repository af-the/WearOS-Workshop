package com.tobiapplications.wearapp.presentation.ui.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Message
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.google.android.horologist.compose.material.ListHeaderDefaults.firstItemPadding
import com.google.android.horologist.compose.material.ResponsiveListHeader
import com.google.android.horologist.compose.material.ToggleChipToggleControl
import com.google.android.horologist.images.base.paintable.ImageVectorPaintable.Companion.asPaintable
import com.tobiapplications.wearapp.presentation.ui.components.AFAppCard
import com.tobiapplications.wearapp.presentation.ui.components.AFChip
import com.tobiapplications.wearapp.presentation.ui.components.AFToggleChip

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun ComponentScreen() {
    // ScalingLazyColumn + rememberResponsiveColumnState handles
    // - position first item near the top on all screen sizes
    // - ensures that last item can be scrolled into view
    // - handle bezel scrolling
    val columnState = rememberResponsiveColumnState(
        contentPadding = ScalingLazyColumnDefaults.padding(
            first = ScalingLazyColumnDefaults.ItemType.Text,
            last = ScalingLazyColumnDefaults.ItemType.Chip
        )
    )
    var switchChecked by remember { mutableStateOf(true) }
    var radioChecked by remember { mutableStateOf(true) }
    var checkboxChecked by remember { mutableStateOf(true) }
    val contentModifier = Modifier
        .padding(top = 4.dp)
        .fillMaxWidth()

    // Scaffold used to be placed inside navigation
    // Handles
    // - scrolls out timeText with your screen
    // - adds scrollbar
    ScreenScaffold(
        scrollState = columnState,
    ) {
        ScalingLazyColumn(
            columnState = columnState
        ) {
            item {
                ResponsiveListHeader(
                    contentPadding = firstItemPadding()
                ) {
                    Text(
                        text = "AF App Chips",
                    )
                }
            }

            item {
                AFChip(
                    label = "Face",
                    secondaryLabel = "subtitle",
                    icon = Icons.Default.Face.asPaintable(),
                    onClick = {},
                    modifier = contentModifier
                )
            }

            item {
                AFAppCard(
                    icon = Icons.AutoMirrored.Rounded.Message.asPaintable(),
                    appName = "AF Wear App",
                    time = "12m",
                    title = "Wear OS Workshop",
                    text = "It's fun creating my first Wear OS App :)",
                    modifier = contentModifier
                )
            }
            item {
                AFToggleChip(
                    checked = switchChecked,
                    onCheckedChange = {
                        switchChecked = it
                    },
                    text = "Switch Chip",
                    toggleChipToggleControl = ToggleChipToggleControl.Switch,
                    modifier = contentModifier
                )
            }
            item {
                AFToggleChip(
                    checked = checkboxChecked,
                    onCheckedChange = {
                        checkboxChecked = it
                    },
                    text = "Checkbox Chip",
                    toggleChipToggleControl = ToggleChipToggleControl.Checkbox,
                    modifier = contentModifier
                )
            }
            item {
                AFToggleChip(
                    checked = radioChecked,
                    onCheckedChange = {
                        radioChecked = it
                    },
                    text = "Radio Chip",
                    toggleChipToggleControl = ToggleChipToggleControl.Radio,
                    modifier = contentModifier
                )
            }
        }
    }
}

@WearPreviewDevices
@Composable
private fun ComponentScreenPreview() {
    ComponentScreen()
}
