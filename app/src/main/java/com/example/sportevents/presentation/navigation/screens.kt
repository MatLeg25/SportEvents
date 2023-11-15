package com.example.sportevents.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Notifications

val screens = listOf(
    BottomNavigationItem(
        title = "Events",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
        route = Route.EVENTS
    ),
    BottomNavigationItem(
        title = "Schedule",
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Outlined.List,
        route = Route.SCHEDULE
    )
)