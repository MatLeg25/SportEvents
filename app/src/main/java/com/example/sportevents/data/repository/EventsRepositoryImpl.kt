package com.example.sportevents.data.repository

import com.example.sportevents.data.mappers.toDomainModel
import com.example.sportevents.data.remote.EventsApi
import com.example.sportevents.domain.model.Event
import com.example.sportevents.domain.model.Schedule
import com.example.sportevents.domain.repository.EventsRepository
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val api: EventsApi
): EventsRepository {

    override suspend fun getEvents(): Result<List<Event>> {
        return try {
            val response = api.getEvents()
                .map { it.toDomainModel() }
                .sortedBy { it.date }
            Result.success(response)
        } catch (e: IOException) {
            e.printStackTrace()
            Result.failure(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getSchedules(): Result<List<Schedule>> {
        return try {
            val response = api.getSchedule()
                .map { it.toDomainModel() }
                .sortedBy { it.date }
            Result.success(response)
        } catch (e: IOException) {
            e.printStackTrace()
            Result.failure(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}