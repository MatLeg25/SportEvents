package com.example.sportevents.presentation.events_screen

import android.net.Uri
import com.example.sportevents.domain.model.Event

data class EventsState(
    val events: List<Event> = emptyList(),
    val displayVideoPlayer: Boolean = false,
    val videoUri: Uri? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)