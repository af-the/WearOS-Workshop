package com.tobiapplications.wearapp.presentation.ui.screens.workout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices

@Composable
fun WorkoutScreen() {
    var running by remember { mutableStateOf(false) }
//
//    item {
//        Button(
//            modifier = contentModifier
//                .fillMaxWidth(0.8f),
//            onClick = { }
//        ) {
//
//            val label = if (running) {
//                stringResource(R.string.stop_walking_workout_button_text)
//            } else {
//                stringResource(R.string.start_walking_workout_button_text)
//            }
//            Text(
//                text = label,
//                textAlign = TextAlign.Center,
//            )
//        }
//    }
}

@WearPreviewDevices
@Composable
private fun WorkoutScreenPreview() {
   WorkoutScreen()
}