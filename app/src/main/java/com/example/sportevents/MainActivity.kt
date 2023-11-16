package com.example.sportevents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sportevents.presentation.schedule_screen.ScheduleScreen
import com.example.sportevents.ui.theme.SportEventsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SportEventsTheme {
                ScheduleScreen()
            }
        }
    }
}
