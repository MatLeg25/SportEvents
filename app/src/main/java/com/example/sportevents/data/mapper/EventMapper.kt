package com.example.sportevents.data.mapper

import com.example.sportevents.data.remote.dto.EventDto
import com.example.sportevents.domain.model.Event
import java.time.ZonedDateTime

fun EventDto.toDomainModel(): Event {
    return Event(
        date = ZonedDateTime.parse(this.date),
        id = this.id,
        imageUrl = this.imageUrl,
        subtitle = this.subtitle,
        title = this.title,
        videoUrl = this.videoUrl
    )
}

