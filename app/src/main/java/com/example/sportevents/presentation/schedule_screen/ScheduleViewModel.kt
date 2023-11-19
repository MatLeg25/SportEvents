package com.example.sportevents.presentation.schedule_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetSchedulesUseCase
import com.example.sportevents.util.extension.toUiEventModel
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
        getSportSchedules()
        screenRefresher()
    }

    private fun getSportSchedules() {
        viewModelScope.launch {
            getSchedulesUseCase()
                .onSuccess { schedules ->
                    state = state.copy(
                        schedules = schedules.map { it.toUiEventModel() },
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

    private fun screenRefresher(){
        viewModelScope.launch {
            while (autoRefreshActive) {
                delay(30.seconds)
                getSportSchedules()
            }
        }
    }


}