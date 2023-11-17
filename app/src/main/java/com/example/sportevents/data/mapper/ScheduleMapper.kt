package com.example.sportevents.data.mapper

import com.example.sportevents.data.remote.dto.ScheduleDto
import com.example.sportevents.domain.model.Schedule
import java.time.ZonedDateTime

fun ScheduleDto.toDomainModel(): Schedule =
    Schedule(
        date = ZonedDateTime.parse(this.date),
        id = this.id,
        imageUrl = this.imageUrl,
        subtitle = this.subtitle,
        title = this.title
    )