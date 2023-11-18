package com.example.sportevents.domain.use_case

import com.example.sportevents.domain.model.Schedule
import com.example.sportevents.domain.repository.EventsRepository
import com.example.sportevents.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSchedulesUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    suspend operator fun invoke(): Resource<List<Schedule>> {
        return eventsRepository.getSchedules()
    }

}