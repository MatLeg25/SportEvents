package com.example.sportevents.domain.repository

import com.example.sportevents.domain.model.Event
import com.example.sportevents.domain.model.Schedule

interface EventsRepository {
    suspend fun getEvents(): Result<List<Event>>
    suspend fun getSchedules(): Result<List<Schedule>>
}