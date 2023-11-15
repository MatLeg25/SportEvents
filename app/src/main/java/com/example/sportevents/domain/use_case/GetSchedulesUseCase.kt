package com.example.sportevents.domain.use_case

import com.example.sportevents.data.remote.EventsApi
import com.example.sportevents.data.remote.dto.EventDto
import com.example.sportevents.data.remote.dto.ScheduleDto
import com.example.sportevents.util.Resource
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSchedulesUseCase @Inject constructor(
    private val api: EventsApi
) {
    suspend operator fun invoke(): Resource<List<ScheduleDto>> {
        return try {
            val response = api.getSchedule()
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