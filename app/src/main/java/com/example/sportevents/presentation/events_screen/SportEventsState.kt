package com.example.sportevents.presentation.events_screen

import com.example.sportevents.domain.model.SportEvent

data class SportEventsState(
    val events: List<SportEvent> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)