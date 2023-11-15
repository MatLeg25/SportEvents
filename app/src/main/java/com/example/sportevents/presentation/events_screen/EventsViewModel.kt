package com.example.sportevents.presentation.events_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class EventsViewModel @Inject constructor(

): ViewModel() {
    init {
        println("init block works")
    }
}