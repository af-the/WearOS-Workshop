package com.tobiapplications.wearapp.presentation.ui.tile

import androidx.wear.protolayout.ResourceBuilders
import androidx.wear.tiles.RequestBuilders
import androidx.wear.tiles.TileBuilders
import coil.imageLoader
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.tiles.SuspendingTileService
import com.tobiapplications.wearapp.presentation.utils.fetchAvatarsFromNetwork

// SuspendingTileService
// Base class for a Kotlin and Coroutines friendly TileService.
// Also acts like a LifecycleService, allowing lifecycleScope, and general lifecycle operations.
@OptIn(ExperimentalHorologistApi::class)
internal class TileService : SuspendingTileService() {

    private val tileRenderer = TileRenderer(this)

    // Possible TODOs => access e.g. repository to get latest data to display

    override suspend fun tileRequest(requestParams: RequestBuilders.TileRequest): TileBuilders.Tile {
        return tileRenderer.renderTimeline(
            state = Sample.data,
            requestParams = requestParams
        )
    }

    // Requests resources. Must be completed within ~10 seconds or timeout
    override suspend fun resourcesRequest(requestParams: RequestBuilders.ResourcesRequest): ResourceBuilders.Resources {
        // Since we know there's only very small avatars, we'll fetch them
        // as part of this resource request.
        val avatars = imageLoader.fetchAvatarsFromNetwork(
            context = this,
            requestParams = requestParams,
            contactList = Sample.data
        )
        // then pass the bitmaps to the renderer to transform them to ImageResources
        return tileRenderer.produceRequestedResources(avatars, requestParams)
    }
}