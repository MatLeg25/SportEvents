package com.example.sportevents.presentation.events_screen

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.exoplayer.ExoPlayer
import com.example.sportevents.domain.use_case.GetEventsUseCase
import com.example.sportevents.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO associate video player with activity lifecycle (fe. : stop player when user minimalist app, toggle tabs)

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
    val exoPlayer: ExoPlayer
): ViewModel() {

    var state by mutableStateOf(SportEventsState(isLoading = true))
        private set

    init {
        getEvents()
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    private fun getEvents() {
        viewModelScope.launch {
            when (val result = getEventsUseCase()) {
                is Resource.Success -> {
                    result.data?.let { events ->
                        state = state.copy(
                            events = events,
                            error = null,
                            isLoading = false
                        )
                    }
                }
                is Resource.Error -> {
                    state = state.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
            }
        }
    }


    //TODO uriString validation?
    fun playVideo(uriString: String) {
        val uri = Uri.parse(uriString)
        state = state.copy(
            displayVideoPlayer = true,
            videoUri = uri
        )
    }

    fun stopVideo() {
        state = state.copy(
            displayVideoPlayer = false
        )
        exoPlayer.pause()
        exoPlayer.playWhenReady = false
    }

    override fun onCleared() {
        super.onCleared()
        exoPlayer.release()
    }

}