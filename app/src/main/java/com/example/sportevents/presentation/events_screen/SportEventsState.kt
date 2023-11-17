package com.example.sportevents.presentation.events_screen

import android.net.Uri
import com.example.sportevents.domain.model.SportEvent

data class SportEventsState(
    val events: List<SportEvent> = emptyList(),
    val displayVideoPlayer: Boolean = false,
    val videoUri: Uri? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)