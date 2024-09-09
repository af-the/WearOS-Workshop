package com.tobiapplications.wearapp.presentation.ui.screens.main

import androidx.compose.runtime.Composable
import com.google.android.horologist.compose.layout.AppScaffold

@Composable
fun MainScreen() {
    // Host for SwipeDismissableNavHost
    // - shows TimeText on top of screen
    // - Without this, the vanilla Scaffold is likely placed on each individual screen and TimeText
    //   moves with the screen, or shown twice when swiping to dismiss.
    AppScaffold {
        MainNavHost()
    }
}