package com.example.sportevents.domain.model

data class SportSchedule(
    val date: String,
    val id: String,
    val imageUrl: String,
    val subtitle: String,
    val title: String,
    val videoUrl: String?
)