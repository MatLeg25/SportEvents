package com.example.sportevents.presentation.schedule_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportevents.domain.use_case.GetSchedulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSchedulesUseCase: GetSchedulesUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            println("initImpl response -- Y0 ")
            val b = getSchedulesUseCase()
            println("initImpl response -- Y1 b = $b")
        }

    }
}