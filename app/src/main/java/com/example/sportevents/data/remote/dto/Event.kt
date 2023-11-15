package com.example.sportevents.data.remote.dto

data class Event(
    val id: String,
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: String,
    val videoUrl: String
)