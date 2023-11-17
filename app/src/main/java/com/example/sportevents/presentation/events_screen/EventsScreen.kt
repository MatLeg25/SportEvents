package com.example.sportevents.presentation.events_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sportevents.domain.mappers.toUiEventModel
import com.example.sportevents.util.component.EventItem
import com.example.sportevents.util.component.ErrorInfo
import com.example.sportevents.util.component.VideoPlayer

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
                items(state.events.size) { index ->
                    val event = state.events[index]
                    EventItem(
                        eventModel = event.toUiEventModel(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable {
                                event.videoUrl?.let { videoUrl ->
                                    viewModel.playVideo(videoUrl)
                                }
                            }
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