package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.habits2.data.HabitViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(
    navController: NavController,
    viewModel: HabitViewModel = HabitViewModel(),
) {
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.padding(Consts.paddingMedium).fillMaxHeight(),
        containerColor = MaterialTheme.colorScheme.primary,
        bottomBar = {

        }
    ) {
        paddingValues ->
    }
}