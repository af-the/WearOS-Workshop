package com.tobiapplications.wearapp.presentation.ui.tile

import android.content.Context
import android.graphics.Bitmap
import androidx.wear.protolayout.DeviceParametersBuilders
import androidx.wear.protolayout.LayoutElementBuilders
import androidx.wear.protolayout.ModifiersBuilders
import androidx.wear.protolayout.ResourceBuilders.Resources
import androidx.wear.protolayout.material.Button
import androidx.wear.protolayout.material.CompactChip
import androidx.wear.protolayout.material.layouts.MultiButtonLayout
import androidx.wear.protolayout.material.layouts.PrimaryLayout
import androidx.wear.tiles.tooling.preview.Preview
import androidx.wear.tiles.tooling.preview.TilePreviewData
import com.google.android.horologist.annotations.ExperimentalHorologistApi
import com.google.android.horologist.tiles.images.drawableResToImageResource
import com.google.android.horologist.tiles.images.toImageResource
import com.google.android.horologist.tiles.render.SingleTileLayoutRenderer
import com.tobiapplications.wearapp.R

private const val ID_IC_SEARCH = "ic_search"

@OptIn(ExperimentalHorologistApi::class)
internal class TileRenderer(context: Context) :
    SingleTileLayoutRenderer<List<Contact>, Map<Contact, Bitmap>>(context) {

    override fun renderTile(
        state: List<Contact>,
        deviceParameters: DeviceParametersBuilders.DeviceParameters
    ): LayoutElementBuilders.LayoutElement {
        return contactTileLayout(
            context = context,
            deviceParameters = deviceParameters,
            contacts = state,
            searchButtonClickable = launchActivityClickable("search_button", openSearch(context = context))
        )
    }

    override fun Resources.Builder.produceRequestedResources(
        resourceState: Map<Contact, Bitmap>,
        deviceParameters: DeviceParametersBuilders.DeviceParameters,
        resourceIds: List<String>
    ) {
        addIdToImageMapping(ID_IC_SEARCH, drawableResToImageResource(R.drawable.ic_search))
        resourceState.forEach { (contact, bitmap) ->
            addIdToImageMapping(
                contact.imageResourceId(),
                bitmap.toImageResource()
            )
        }
    }

    private fun contactTileLayout(
        context: Context,
        deviceParameters: DeviceParametersBuilders.DeviceParameters,
        contacts: List<Contact>,
        searchButtonClickable: ModifiersBuilders.Clickable
    ): PrimaryLayout {
        return PrimaryLayout.Builder(deviceParameters)
            .setResponsiveContentInsetEnabled(true)
            .setContent(
                MultiButtonLayout.Builder()
                    .apply {
                        contacts.take(4).forEach { data ->
                            addButtonContent(
                                buttonLayout(
                                    context = context,
                                    contact = data,
                                    clickable = launchActivityClickable(
                                        clickableId = data.name,
                                        androidActivity = openTileActivity(
                                            context = context,
                                            contact = data
                                        )
                                    )
                                )
                            )
                        }
                    }
                    .addButtonContent(searchLayout(context, searchButtonClickable))
                    .build()
            )
            .setPrimaryChipContent(
                CompactChip.Builder(
                    context,
                    context.getString(R.string.tile_messaging_create_new),
                    launchActivityClickable(
                        clickableId = "search",
                        androidActivity = openNewConversation(context = context)
                    ),
                    deviceParameters
                )
                    .build()
            )
            .build()
    }

    private fun buttonLayout(
        context: Context,
        contact: Contact,
        clickable: ModifiersBuilders.Clickable
    ): Button {
        return Button.Builder(context, clickable)
            .setContentDescription(contact.name)
            .setImageContent(contact.imageResourceId())
//            .setTextContent(contact.name.first().toString())
            .build()
    }

    private fun searchLayout(
        context: Context,
        clickable: ModifiersBuilders.Clickable,
    ) = Button.Builder(context, clickable)
        .setContentDescription(context.getString(R.string.tile_messaging_search))
        .setIconContent(ID_IC_SEARCH)
        .build()
}

@Preview
fun tileLayoutPreview(context: Context): TilePreviewData {
    return TilePreviewData({ previewResources() }) { request ->
        TileRenderer(context).renderTimeline(
            Sample.data,
            request
        )
    }
}

private fun previewResources() = Resources.Builder().apply {
    addIdToImageMapping(ID_IC_SEARCH, drawableResToImageResource(R.drawable.ic_search))
    Sample.data.forEach {
        addIdToImageMapping(
            it.imageResourceId(),
            drawableResToImageResource(R.drawable.splash_icon)
        )
    }
}.build()

