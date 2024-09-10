package com.tobiapplications.wearapp.presentation.ui.tile

import android.content.Context
import androidx.wear.protolayout.ActionBuilders
import androidx.wear.protolayout.ModifiersBuilders

internal fun launchActivityClickable(
    clickableId: String,
    androidActivity: ActionBuilders.AndroidActivity
) = ModifiersBuilders.Clickable.Builder()
    .setId(clickableId)
    .setOnClick(
        ActionBuilders.LaunchAction.Builder()
            .setAndroidActivity(androidActivity)
            .build()
    )
    .build()


internal fun openTileActivity(context: Context, contact: Contact) = ActionBuilders.AndroidActivity.Builder()
    .setTileActivity(context = context)
    .addKeyToExtraMapping(
        TileActivity.EXTRA_JOURNEY,
        ActionBuilders.stringExtra(TileActivity.EXTRA_JOURNEY_CONVERSATION)
    )
    .addKeyToExtraMapping(
        TileActivity.EXTRA_CONVERSATION_CONTACT,
        ActionBuilders.stringExtra(contact.name)
    )
    .build()

internal fun openNewConversation(context: Context) = ActionBuilders.AndroidActivity.Builder()
    .setTileActivity(context = context)
    .addKeyToExtraMapping(
        TileActivity.EXTRA_JOURNEY,
        ActionBuilders.stringExtra(TileActivity.EXTRA_JOURNEY_NEW)
    )
    .build()

internal fun openSearch(context: Context) = ActionBuilders.AndroidActivity.Builder()
    .setTileActivity(context = context)
    .addKeyToExtraMapping(
        TileActivity.EXTRA_JOURNEY,
        ActionBuilders.stringExtra(TileActivity.EXTRA_JOURNEY_SEARCH)
    )
    .build()

internal fun ActionBuilders.AndroidActivity.Builder.setTileActivity(context: Context) : ActionBuilders.AndroidActivity.Builder {
    return setPackageName(context.packageName)
        .setClassName(TileActivity::class.java.name)
}