package com.example.sportevents.data.mapper

import com.example.sportevents.data.remote.dto.EventDto
import com.example.sportevents.domain.model.SportEvent
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun EventDto.toDomainModel(): SportEvent {
    return SportEvent(
        date = ZonedDateTime.parse(this.date),
        id = this.id,
        imageUrl = this.imageUrl,
        subtitle = this.subtitle,
        title = this.title,
        videoUrl = this.videoUrl
    )
}

