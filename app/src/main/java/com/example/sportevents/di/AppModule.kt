package com.example.sportevents.di

import android.app.Application
import androidx.media3.exoplayer.ExoPlayer
import com.example.sportevents.data.remote.EventsApi
import com.example.sportevents.data.repository.EventsRepositoryImpl
import com.example.sportevents.domain.repository.EventsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOpenFoodApi(): EventsApi {
        return Retrofit.Builder()
            .baseUrl(EventsApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideExoPlayer(app: Application): ExoPlayer {
        return ExoPlayer.Builder(app).build()
    }

    @Provides
    @Singleton
    fun provideEventsRepository(api: EventsApi): EventsRepository {
        return EventsRepositoryImpl(api)
    }

}