package de.appsfactory.wearapp.ui.screens.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.google.android.horologist.compose.layout.ScreenScaffold
import de.appsfactory.wearapp.navigation.Screen

@Composable
fun StartScreen(
    navigateTo: (Screen) -> Unit
) {
    ScreenScaffold {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {
                    navigateTo(Screen.Component)
                },
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f)
                    .align(Alignment.Center)
            ) {
                Text("Components")
            }
        }
    }
}

@WearPreviewDevices
@Composable
private fun StartScreenPreview() {
    StartScreen { }
}