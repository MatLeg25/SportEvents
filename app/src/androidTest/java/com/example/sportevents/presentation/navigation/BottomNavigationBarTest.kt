package com.example.sportevents.presentation.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BottomNavigationBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupBottomNavigationBar() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            BottomNavigationBar(navController = navController)
        }
    }

    @Test
    fun bottomNavigationBar_verifyStartDestination() {
        composeTestRule
            .onNodeWithText("Events")
            .assertIsDisplayed()
    }

    //todo update this test (problems with access to navController.currentBackStackEntry)
    @Test
    fun bottomNavigationBar_afterClick_navigateToSchedule() {
        composeTestRule
            .onNodeWithText("Schedule")
            .performClick()

         val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "schedule")
    }
}