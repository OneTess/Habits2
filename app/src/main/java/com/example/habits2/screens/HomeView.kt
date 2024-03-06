package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.habits2.data.HabitViewModel
import com.example.habits2.uiElements.NavigationBarView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // TODO: Remove this
@Composable
fun HomeView(
    navController: NavController,
    viewModel: HabitViewModel = HabitViewModel(),
) {
    Scaffold(
        modifier = Modifier
            .padding(Consts.paddingMedium)
            .fillMaxHeight(),
        bottomBar = {
            NavigationBarView()
        }
    ) {
        paddingValues ->
    }
}