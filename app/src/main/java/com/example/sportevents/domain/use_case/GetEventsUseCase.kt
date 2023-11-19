package com.example.sportevents.domain.use_case

import com.example.sportevents.domain.model.Event
import com.example.sportevents.domain.repository.EventsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetEventsUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    suspend operator fun invoke(): Result<List<Event>> {
        return eventsRepository.getEvents()
    }

}