package com.example.sportevents.presentation.events_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetEventsUseCase
import com.example.sportevents.domain.use_case.GetSchedulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
    private val getSchedulesUseCase: GetSchedulesUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            println("initImpl response -- Y0 ")
            val a = getEventsUseCase()
            val b = getSchedulesUseCase()
            println("initImpl response -- Y1 a = $a")
            println("initImpl response xxxxxxxx")
            println("initImpl response -- Y1 b = $b")
        }

    }
}