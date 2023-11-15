package com.example.sportevents.domain.use_case

import com.example.sportevents.data.mapper.toDomainModel
import com.example.sportevents.data.remote.EventsApi
import com.example.sportevents.data.remote.dto.EventDto
import com.example.sportevents.domain.model.SportEvent
import com.example.sportevents.util.Resource
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetEventsUseCase @Inject constructor(
    private val api: EventsApi
) {
    suspend operator fun invoke(): Resource<List<SportEvent>> {
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

}