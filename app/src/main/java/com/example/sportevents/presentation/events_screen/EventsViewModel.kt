package com.example.sportevents.presentation.events_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase,
): ViewModel() {
    init {
        viewModelScope.launch {
            println("initImpl response -- Y0 ")
            val a = getEventsUseCase()
            println("initImpl response -- Y1 a = $a")
        }

    }
}