package com.example.sportevents.presentation.schedule_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sportevents.util.component.VideoPlayer

@Preview
@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                viewModel.playVideo("https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o/promo.mp4?alt=media")
            }
        ) {

        }
        Text(text = "SCHEDULE")
        if (state.displayVideoPlayer && state.videoUri != null) { //IMPROVE display snackbar when uri is null
            VideoPlayer(
                uri = state.videoUri,
                exoPlayer = viewModel.exoPlayer,
                onDismiss = { viewModel.stopVideo() }
            )
        }
    }

}