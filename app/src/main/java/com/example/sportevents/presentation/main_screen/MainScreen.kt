package com.example.sportevents.presentation.main_screen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.sportevents.presentation.navigation.BottomNavGraph
import com.example.sportevents.presentation.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    )
    { innerPadding ->
        // Apply the padding globally to the entire BottomNavGraph,
        // to prevent BottomNavigationBar from overlapping the screen content
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController)
        }
    }
}

