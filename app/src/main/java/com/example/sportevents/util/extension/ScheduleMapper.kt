package com.example.sportevents.util.extension

import com.example.sportevents.domain.model.Schedule
import com.example.sportevents.util.models.UiEventModel

fun Schedule.toUiEventModel() = UiEventModel(
    date = date,
    id = id,
    imageUrl = imageUrl,
    subtitle = subtitle,
    title = title,
)