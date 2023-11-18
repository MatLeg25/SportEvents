package com.example.sportevents.presentation.events_screen

import android.net.Uri
import com.example.sportevents.util.models.UiEventModel

data class EventsState(
    val events: List<UiEventModel> = emptyList(),
    val displayVideoPlayer: Boolean = false,
    val videoUri: Uri? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)