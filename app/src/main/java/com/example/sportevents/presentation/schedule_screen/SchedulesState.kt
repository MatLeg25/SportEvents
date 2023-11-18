package com.example.sportevents.presentation.schedule_screen

import com.example.sportevents.util.models.UiEventModel

data class SchedulesState(
    val schedules: List<UiEventModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)