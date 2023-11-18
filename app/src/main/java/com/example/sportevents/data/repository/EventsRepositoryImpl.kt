package com.example.sportevents.data.repository

import com.example.sportevents.data.mapper.toDomainModel
import com.example.sportevents.data.remote.EventsApi
import com.example.sportevents.domain.model.Event
import com.example.sportevents.domain.model.Schedule
import com.example.sportevents.domain.repository.EventsRepository
import com.example.sportevents.util.Resource
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

class EventsRepositoryImpl @Inject constructor(
    private val api: EventsApi
): EventsRepository {
    override suspend fun getEvents(): Resource<List<Event>> {
        return try {
            val response = api.getEvents()
                .map { it.toDomainModel() }
                .sortedBy { it.date }
            Resource.Success(response)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Couldn't load events")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Couldn't load events")
        }
    }

    override suspend fun getSchedules(): Resource<List<Schedule>> {
        return try {
            val response = api.getSchedule()
                .map { it.toDomainModel() }
                .sortedBy { it.date }
            Resource.Success(response)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error("Couldn't load events")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Couldn't load events")
        }
    }
}