package com.example.sportevents.data.remote.dto

data class EventDto(
    val date: String,
    val id: String,
    val imageUrl: String,
    val subtitle: String,
    val title: String,
    val videoUrl: String
)