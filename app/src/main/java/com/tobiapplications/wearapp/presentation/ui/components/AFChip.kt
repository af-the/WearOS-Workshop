package com.tobiapplications.wearapp.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.material.Chip
import com.google.android.horologist.images.base.paintable.Paintable

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun AFChip(
    label: String,
    secondaryLabel: String?,
    onClick: () -> Unit,
    icon: Paintable,
    modifier: Modifier = Modifier
) {
    Chip(
        label = label,
        onClick = onClick,
        secondaryLabel = secondaryLabel,
        icon = icon,
        modifier = modifier
    )
}