package de.appsfactory.wearapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.wear.tiles.RequestBuilders
import coil.ImageLoader
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import de.appsfactory.wearapp.ui.tile.Contact
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * Each contact in the tile state could have an avatar (represented by image url).
 *
 * If the image resources are requested (the ID is in [requestParams] or no IDs were specified),
 * then we fetch them from the network in this suspending function, returning the resulting bitmaps.
 */
internal suspend fun ImageLoader.fetchAvatarsFromNetwork(
    context: Context,
    requestParams: RequestBuilders.ResourcesRequest,
    contactList: List<Contact>,
): Map<Contact, Bitmap> {
    val requestedAvatars: List<Contact> = if (requestParams.resourceIds.isEmpty()) {
        contactList
    } else {
        contactList.filter {
            requestParams.resourceIds.contains(it.imageResourceId())
        }
    }

    val images = coroutineScope {
        requestedAvatars.map { contact ->
            async {
                val image = loadAvatar(context, contact)
                image?.let { contact to it }
            }
        }
    }.awaitAll().filterNotNull().toMap()

    return images
}


private suspend fun ImageLoader.loadAvatar(
    context: Context,
    contact: Contact,
    size: Int? = 64
): Bitmap? {
    val request = ImageRequest.Builder(context)
        .data(contact.url)
        .apply {
            if (size != null) {
                size(size)
            }
        }
        .allowRgb565(true)
        .transformations(CircleCropTransformation())
        .allowHardware(false)
        .target {
            (it as BitmapDrawable).bitmap
        }
        .build()
    val response = execute(request)
    return (response.drawable as? BitmapDrawable)?.bitmap
}
