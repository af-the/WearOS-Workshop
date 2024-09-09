package com.tobiapplications.wearapp.presentation.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.compose.nav.SwipeDismissableNavHost
import com.google.android.horologist.compose.nav.composable
import com.tobiapplications.wearapp.presentation.navigation.Screen
import com.tobiapplications.wearapp.presentation.ui.screens.components.ComponentRoute
import com.tobiapplications.wearapp.presentation.ui.screens.start.StartRoute
import com.tobiapplications.wearapp.presentation.ui.screens.workout.WorkoutRoute

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
        composable<Screen.Workout> {
            WorkoutRoute()
        }
    }
}