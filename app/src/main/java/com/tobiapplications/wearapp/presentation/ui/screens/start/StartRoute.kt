package com.tobiapplications.wearapp.presentation.ui.screens.start

import androidx.compose.runtime.Composable
import com.tobiapplications.wearapp.presentation.navigation.Screen

@Composable
fun StartRoute(
    navigateTo: (Screen) -> Unit
) {
    StartScreen(
        navigateTo = navigateTo
    )
}