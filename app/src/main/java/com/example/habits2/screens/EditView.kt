package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel
import com.example.habits2.methods.autosave
import com.example.habits2.uiElements.CustomTextField
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
            .padding(top = Consts.paddingGlobalSmall)
            .fillMaxSize(),
        bottomBar = {
            NavigationBarView(
                currentScreenName = "edit",
                onNavigationBarButtonClicked = { /* TODO: Mark completed functionality */ }
            )
        }
    ) {
        paddingValues ->

        val context = LocalContext.current

        val scope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()
        if (id != 0) {
            val habit = viewModel.getHabit(id).collectAsState(initial = HabitData(id = 0, title = "", content = ""))
            viewModel.onHabitTitleChanged(habit.value.title)
            viewModel.onHabitContentsChanged(habit.value.content)
        } else {
            viewModel.onHabitTitleChanged("")
            viewModel.onHabitContentsChanged("")
        }

        val title by viewModel.habitTitleState.collectAsState()
        val contents by viewModel.habitContentState.collectAsState()

        Column {
            CustomTextField(
                value = title,
                onValueChange = {
                    /* TODO */
                }
            )
        }
    }
}