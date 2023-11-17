package com.example.sportevents.domain.mappers

import com.example.sportevents.domain.model.SportSchedule
import com.example.sportevents.util.model.UiEventModel

fun SportSchedule.toUiEventModel() = UiEventModel(
    date = date,
    id = id,
    imageUrl = imageUrl,
    subtitle = subtitle,
    title = title,
    videoUrl = videoUrl,
)