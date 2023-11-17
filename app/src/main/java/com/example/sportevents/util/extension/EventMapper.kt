package com.example.sportevents.util.extension

import com.example.sportevents.domain.model.Event
import com.example.sportevents.util.models.UiEventModel

fun Event.toUiEventModel() = UiEventModel(
    date = date,
    id = id,
    imageUrl = imageUrl,
    subtitle = subtitle,
    title = title,
)