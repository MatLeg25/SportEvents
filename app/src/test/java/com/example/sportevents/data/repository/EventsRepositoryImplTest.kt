package com.example.sportevents.data.repository

import com.example.sportevents.data.remote.EventsApi
import com.example.sportevents.data.remote.invalidEventsResponse
import com.example.sportevents.data.remote.validEventsResponse
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class EventsRepositoryImplTest {

    private lateinit var repository: EventsRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: EventsApi


    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url(""))
            .build()
            .create(EventsApi::class.java)
        repository = EventsRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get events, valid response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validEventsResponse)
        )
        val result = repository.getEvents()

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Get events, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(validEventsResponse)
        )
        val result = repository.getEvents()
        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Get events, invalid response format, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(invalidEventsResponse)
        )
        val result = repository.getEvents()
        assertThat(result.isFailure).isTrue()
    }

}