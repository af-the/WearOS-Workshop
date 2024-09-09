package com.tobiapplications.wearapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Start : Screen

    @Serializable
    data object Component : Screen

    @Serializable
    data object Workout : Screen
}