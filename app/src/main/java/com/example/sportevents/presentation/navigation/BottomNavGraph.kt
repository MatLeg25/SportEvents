package com.example.sportevents.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sportevents.presentation.events_screen.EventsScreen
import com.example.sportevents.presentation.schedule_screen.ScheduleScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.EVENTS
    ) {
        composable(route = Route.EVENTS) {
            EventsScreen()
        }
        composable(route = Route.SCHEDULE) {
            ScheduleScreen()
        }
    }
}