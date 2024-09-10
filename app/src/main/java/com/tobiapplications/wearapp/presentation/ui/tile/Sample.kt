package com.tobiapplications.wearapp.presentation.ui.tile

import kotlin.random.Random

internal object Sample {

    val data = listOf(
        Contact(
            id = 1,
            name = "Peter",
            url = "https://picsum.photos/100?random=${Random.nextInt(100)}"
        ),
        Contact(
            id = 2,
            name = "Susan",
            url = "https://picsum.photos/100?random=${Random.nextInt(100)}"
        ),
        Contact(
            id = 3,
            name = "John",
            url = "https://picsum.photos/100?random=${Random.nextInt(100)}"
        ),
        Contact(
            id = 4,
            name = "Max",
            url = "https://picsum.photos/100?random=${Random.nextInt(100)}"
        ),
        Contact(
            id = 5,
            name = "Isabel",
            url = "https://picsum.photos/100?random=${Random.nextInt(100)}"
        )
    )
}

internal data class Contact(
    val id: Int,
    val name: String,
    val url: String
){
    internal fun imageResourceId() = "contact:$id"
}