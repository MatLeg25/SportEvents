package com.example.sportevents.domain.model

import java.time.ZonedDateTime

data class SportEvent(
    val date: ZonedDateTime,
    val id: String,
    val imageUrl: String,
    val subtitle: String,
    val title: String,
    val videoUrl: String?
)