package com.example.sportevents.presentation.schedule_screen

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.exoplayer.ExoPlayer
import com.example.sportevents.domain.use_case.GetSchedulesUseCase
import com.example.sportevents.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSchedulesUseCase: GetSchedulesUseCase,
    val exoPlayer: ExoPlayer
): ViewModel() {

    var state by mutableStateOf(SportSchedulesState(isLoading = true))
        private set

    init {
        getSportSchedules()
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    private fun getSportSchedules() {
        viewModelScope.launch {
            when (val result = getSchedulesUseCase()) {
                is Resource.Success -> {
                    result.data?.let { schedules ->
                        state = state.copy(
                            schedules = schedules,
                            error = null,
                        )
                    }
                }
                is Resource.Error -> {
                    state = state.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    state = state.copy(
                        isLoading = result.isLoading,
                        error = null,
                    )
                }
            }
        }
    }

    //TODO consider uri validation
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