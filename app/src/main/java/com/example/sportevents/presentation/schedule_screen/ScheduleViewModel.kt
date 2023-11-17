package com.example.sportevents.presentation.schedule_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetSchedulesUseCase
import com.example.sportevents.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

//TODO associate refreshing with the activity lifecycle (e.g.: stop when the user minimizes the application, switches tabs)

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSchedulesUseCase: GetSchedulesUseCase
): ViewModel() {

    private val autoRefreshActive = true
    var state by mutableStateOf(SchedulesState(isLoading = true))
        private set

    init {
        screenRefresher()
    }

    private fun getSportSchedules() {
        viewModelScope.launch {
            when (val result = getSchedulesUseCase()) {
                is Resource.Success -> {
                    result.data?.let { schedules ->
                        state = state.copy(
                            schedules = schedules,
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

    private fun screenRefresher(){
        viewModelScope.launch {
            while (autoRefreshActive) {
                delay(30.seconds)
                getSportSchedules()
            }
        }
    }


}