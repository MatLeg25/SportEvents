package com.example.sportevents.util.extension

import android.net.Uri
import com.example.sportevents.domain.model.Event
import com.example.sportevents.util.models.UiEventModel

fun Event.toUiEventModel(): UiEventModel {
    val uri = videoUrl?.let { Uri.parse(it) }
    return UiEventModel(
        date = date,
        id = id,
        imageUrl = imageUrl,
        subtitle = subtitle,
        title = title,
        videoUri = uri
    )
}