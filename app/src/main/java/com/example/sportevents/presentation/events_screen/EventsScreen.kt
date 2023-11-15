package com.example.sportevents.presentation.events_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sportevents.util.EventItem
import com.example.sportevents.util.component.ErrorInfo

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Column(modifier = Modifier.fillMaxSize()) {
        if (state.error == null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.events.size) { index ->
                    val event = state.events[index]
                    EventItem(
                        event = event,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            }
        }
    }

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

}