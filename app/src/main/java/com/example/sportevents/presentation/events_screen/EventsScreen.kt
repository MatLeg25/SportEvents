package com.example.sportevents.presentation.events_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sportevents.presentation.schedule_screen.components.dateFormatterSchedule
import com.example.sportevents.util.extension.toUiEventModel
import com.example.sportevents.util.components.EventItem
import com.example.sportevents.util.components.ErrorInfo
import com.example.sportevents.util.components.VideoPlayer
import com.example.sportevents.util.components.dateFormatter

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel()
) {

    val state = viewModel.state

    //items list
    Column(modifier = Modifier.fillMaxSize()) {
        if (state.error == null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.events) { event ->
                    val eventModel = event.toUiEventModel()
                    EventItem(
                        eventModel = eventModel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable {
                                event.videoUrl?.let { videoUrl ->
                                    viewModel.playVideo(videoUrl)
                                }
                            },
                        formattedDate = dateFormatter(eventModel.date)
                    )
                }
            }
        }
    }
    //loading or error
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.error != null) {
            ErrorInfo()
        }
    }
    //video player
    if (state.displayVideoPlayer && state.videoUri != null) {
        VideoPlayer(
            uri = state.videoUri,
            exoPlayer = viewModel.exoPlayer,
            onDismiss = { viewModel.stopVideo() }
        )
    }

}