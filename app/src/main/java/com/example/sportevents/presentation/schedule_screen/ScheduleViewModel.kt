package com.example.sportevents.presentation.schedule_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetSchedulesUseCase
import com.example.sportevents.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSchedulesUseCase: GetSchedulesUseCase
): ViewModel() {

    var state by mutableStateOf(SchedulesState(isLoading = true))
        private set

    init {
        getSportSchedules()
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


}