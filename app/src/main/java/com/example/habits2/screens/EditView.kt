package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.habits2.data.MainViewModel
import com.example.habits2.uiElements.NavigationBarView

// TODO: EditView Autosave
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // TODO: Remove this
@Composable
fun EditView(
    id: Int,
    viewModel: MainViewModel,
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBarView(currentScreenName = "edit", onNavigationBarButtonClicked = {})
        }
    ) {
        paddingValues ->
    }
}