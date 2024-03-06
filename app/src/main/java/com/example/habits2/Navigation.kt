package com.example.habitsmatter

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.habits2.data.HabitViewModel
import com.example.habits2.screens.Destinations.EDIT_SCREEN
import com.example.habits2.screens.Destinations.HOME_SCREEN
import com.example.habits2.screens.EditView
import com.example.habits2.screens.HomeView

@Composable
fun Navigation(
    viewModel: HabitViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN,
    ) {
        composable(HOME_SCREEN) {
            HomeView(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(
            route = "$EDIT_SCREEN/{id}", // Enables us to pass an id for the needed Habit.
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ) {
                entry ->
            val id = if(entry.arguments != null) {
                entry.arguments!!.getInt("id") // !! means unpacking the nullable. Whatever that means.
            } else {
                0
            }
            EditView(id = id, viewModel = viewModel, navController = navController)
        }
    }
}
