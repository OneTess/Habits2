package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.habits2.data.MainViewModel
import com.example.habits2.uiElements.NavigationBarView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // TODO: Remove this
@Composable
fun EditView(
    id: Int,
    viewModel: MainViewModel,
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier
            .padding(Consts.paddingMedium)
            .fillMaxHeight(),
        containerColor = MaterialTheme.colorScheme.primary,
        bottomBar = {
            Column {
                NavigationBarView()
            }
        }
    ) {
        paddingValues ->
    }
}