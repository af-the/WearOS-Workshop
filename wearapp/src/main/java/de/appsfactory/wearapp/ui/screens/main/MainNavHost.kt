package de.appsfactory.wearapp.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.nav.SwipeDismissableNavHost
import com.google.android.horologist.compose.nav.composable
import de.appsfactory.wearapp.navigation.Screen
import de.appsfactory.wearapp.ui.screens.components.ComponentRoute
import de.appsfactory.wearapp.ui.screens.start.StartRoute

@OptIn(ExperimentalHorologistApi::class)
@Composable
fun MainNavHost() {
    val navController = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = Screen.Start
    ) {
        composable<Screen.Start> {
            StartRoute {
                navController.navigate(it)
            }
        }
        composable<Screen.Component> {
            ComponentRoute()
        }
    }
}