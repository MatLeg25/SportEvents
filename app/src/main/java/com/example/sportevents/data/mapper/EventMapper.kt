package com.example.sportevents.data.mapper

import com.example.sportevents.data.remote.dto.EventDto
import com.example.sportevents.domain.model.SportEvent

fun EventDto.toDomainModel(): SportEvent =
    SportEvent(
    date = this.date,
    id = this.id,
    imageUrl = this.imageUrl,
    subtitle = this.subtitle,
    title = this.title,
    videoUrl = this.videoUrl,
)