package com.example.sportevents.presentation.events_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetEventsUseCase
import com.example.sportevents.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
): ViewModel() {

    var state by mutableStateOf(SportEventsState())
        private set

    init {
        getSportSchedules()
    }

    private fun getSportSchedules() {
        viewModelScope.launch {
            when (val result = getEventsUseCase()) {
                is Resource.Success -> {
                    result.data?.let { events ->
                        state = state.copy(
                            events = events,
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

}