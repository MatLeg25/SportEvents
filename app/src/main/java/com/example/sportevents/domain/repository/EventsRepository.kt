package com.example.sportevents.domain.repository

import com.example.sportevents.domain.model.Event
import com.example.sportevents.domain.model.Schedule
import com.example.sportevents.util.Resource

interface EventsRepository {
    suspend fun getEvents(): Resource<List<Event>>
    suspend fun getSchedules(): Resource<List<Schedule>>
}