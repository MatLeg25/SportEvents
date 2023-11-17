package com.example.sportevents.domain.mappers

import com.example.sportevents.domain.model.SportEvent
import com.example.sportevents.util.model.UiEventModel

fun SportEvent.toUiEventModel() = UiEventModel(
    date = date,
    id = id,
    imageUrl = imageUrl,
    subtitle = subtitle,
    title = title,
    videoUrl = videoUrl,
)