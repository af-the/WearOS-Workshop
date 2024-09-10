package de.appsfactory.wearapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Start : Screen

    @Serializable
    data object Component : Screen

}