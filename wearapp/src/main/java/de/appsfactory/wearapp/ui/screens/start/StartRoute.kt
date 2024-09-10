package de.appsfactory.wearapp.ui.screens.start

import androidx.compose.runtime.Composable
import de.appsfactory.wearapp.navigation.Screen

@Composable
fun StartRoute(
    navigateTo: (Screen) -> Unit
) {
    StartScreen(
        navigateTo = navigateTo
    )
}