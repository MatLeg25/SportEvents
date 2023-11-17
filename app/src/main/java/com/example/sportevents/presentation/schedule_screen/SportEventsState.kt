package com.example.sportevents.presentation.schedule_screen

import android.net.Uri
import com.example.sportevents.domain.model.SportSchedule

data class SportSchedulesState(
    val schedules: List<SportSchedule> = emptyList(),
    val displayVideoPlayer: Boolean = false,
    val videoUri: Uri? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)