package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel
import com.example.habits2.methods.autosave
import com.example.habits2.uiElements.CustomTextField
import com.example.habits2.uiElements.NavigationBarView

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditView(
    id: Int,
    viewModel: MainViewModel = MainViewModel(),
    navController: NavController
) {
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

    Scaffold(
        modifier = Modifier.padding(top = Consts.paddingMedium).fillMaxSize(),
        topBar = {
                 /* TODO: Dropdown for buttons such as "Delete" */
        },
        bottomBar = {
            NavigationBarView(
                currentScreenName = "edit",
                onNavigationBarButtonClicked = { /* TODO: "Mark completed" functionality */ }
            )
        }
    ) {
            paddingValues ->
        Column(
            modifier = Modifier
                .padding(
                    start = paddingValues.calculateLeftPadding(LayoutDirection.Ltr),
                    end = paddingValues.calculateRightPadding(LayoutDirection.Rtl),
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val title by viewModel.habitTitleState.collectAsState()
            val content by viewModel.habitContentState.collectAsState()

            // Title Text Field
            CustomTextField(
                value = title,
                onValueChange = {
                    viewModel.onHabitTitleChanged(it)
                    autosave(id = id, viewModel = viewModel)
                }
            )
        }
    }
}
