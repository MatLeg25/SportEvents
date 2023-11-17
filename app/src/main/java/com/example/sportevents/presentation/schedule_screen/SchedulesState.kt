package com.example.sportevents.presentation.schedule_screen

import com.example.sportevents.domain.model.Schedule

data class SchedulesState(
    val schedules: List<Schedule> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)