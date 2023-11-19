package com.example.sportevents.presentation.events_screen

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.exoplayer.ExoPlayer
import com.example.sportevents.domain.use_case.GetEventsUseCase
import com.example.sportevents.util.extension.toUiEventModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
    val exoPlayer: ExoPlayer
): ViewModel() {

    var state by mutableStateOf(EventsState(isLoading = true))
        private set

    init {
        getEvents()
    }

    private fun getEvents() {
        viewModelScope.launch {
            getEventsUseCase()
                .onSuccess { events ->
                    state = state.copy(
                        events = events.map { it.toUiEventModel() },
                        error = null,
                        isLoading = false
                    )
                }
                .onFailure {
                    state = state.copy(
                        error = it.message,
                        isLoading = false
                    )
                }
        }
    }

    //TODO uriString validation?
    fun playVideo(uri: Uri) {
        state = state.copy(
            displayVideoPlayer = true,
            videoUri = uri
        )
    }

    fun stopVideo() {
        state = state.copy(
            displayVideoPlayer = false
        )
        exoPlayer.stop()
        exoPlayer.clearMediaItems()
    }

    override fun onCleared() {
        super.onCleared()
        exoPlayer.release()
    }

}