package com.example.sportevents.presentation.schedule_screen

import com.example.sportevents.domain.model.SportSchedule

data class SportSchedulesState(
    val schedules: List<SportSchedule> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)