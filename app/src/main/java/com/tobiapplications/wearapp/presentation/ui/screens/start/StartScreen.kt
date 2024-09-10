package com.tobiapplications.wearapp.presentation.ui.screens.start

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScreenScaffold
import com.google.android.horologist.compose.layout.rememberResponsiveColumnState
import com.tobiapplications.wearapp.presentation.navigation.Screen

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun StartScreen(
    navigateTo: (Screen) -> Unit
) {
    val columnState = rememberResponsiveColumnState()

    ScreenScaffold(
        scrollState = columnState
    ) {
        ScalingLazyColumn(
            columnState = columnState
        ) {
            item {
                Button(
                    onClick = {
                        navigateTo(Screen.Component)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Text("Components")
                }
            }
            item {
                Button(
                    onClick = {
                        navigateTo(Screen.Workout)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Text("Workout")
                }
            }
        }
    }
}

@WearPreviewDevices
@Composable
private fun StartScreenPreview() {
    StartScreen {  }
}