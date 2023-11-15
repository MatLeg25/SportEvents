package com.example.sportevents.data.remote

import com.example.sportevents.data.remote.dto.EventDto
import com.example.sportevents.data.remote.dto.ScheduleDto
import retrofit2.http.GET

interface EventsApi {

    companion object {
        const val BASE_URL = "https://us-central1-dazn-sandbox.cloudfunctions.net/"
    }

    @GET("https://us-central1-dazn-sandbox.cloudfunctions.net/getEvents")
    suspend fun getEvents(): List<EventDto>

    @GET("https://us-central1-dazn-sandbox.cloudfunctions.net/getSchedule")
    suspend fun getSchedule():  List<ScheduleDto>


}