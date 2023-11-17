package com.example.sportevents.data.mapper

import com.example.sportevents.data.remote.dto.ScheduleDto
import com.example.sportevents.domain.model.SportSchedule
import java.time.ZonedDateTime

fun ScheduleDto.toDomainModel(): SportSchedule =
    SportSchedule(
        date = ZonedDateTime.parse(this.date),
        id = this.id,
        imageUrl = this.imageUrl,
        subtitle = this.subtitle,
        title = this.title,
        videoUrl = this.videoUrl,
    )