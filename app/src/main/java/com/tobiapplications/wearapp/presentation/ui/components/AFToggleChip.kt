package com.tobiapplications.wearapp.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.material.ToggleChip
import com.google.android.horologist.compose.material.ToggleChipToggleControl

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun AFToggleChip(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String,
    toggleChipToggleControl: ToggleChipToggleControl,
    modifier: Modifier = Modifier
) {
    ToggleChip(
        checked = checked,
        onCheckedChanged = onCheckedChange,
        label = text,
        toggleControl = toggleChipToggleControl,
        modifier = modifier
    )
}