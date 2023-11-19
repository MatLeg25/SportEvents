package com.example.sportevents.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.outline,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        screens.forEachIndexed { index, item ->
            val isSelected = (selectedItemIndex == index)
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route)
                },
                label = {
                    Text(
                        text = item.title,
                        color = MaterialTheme.colorScheme.outlineVariant,
                        style = MaterialTheme.typography.labelSmall,
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}
