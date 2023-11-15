package com.example.sportevents.data.remote

import com.example.sportevents.data.remote.dto.EventsDto
import com.example.sportevents.data.remote.dto.SchedulesDto
import retrofit2.http.GET

interface EventsApi {

    companion object {
        const val BASE_URL = "https://us-central1-dazn-sandbox.cloudfunctions.net/"
    }

    @GET("https://us-central1-dazn-sandbox.cloudfunctions.net/getEvents")
    suspend fun getEvents(): EventsDto

    @GET("https://us-central1-dazn-sandbox.cloudfunctions.net/getSchedule")
    suspend fun getSchedule(): SchedulesDto


}