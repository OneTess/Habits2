package com.example.habits2.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.habits2.R
import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel
import com.example.habits2.uiElements.CalendarWeekCompactView
import com.example.habits2.uiElements.CustomTextField
import com.example.habits2.uiElements.HabitItemView
import com.example.habits2.uiElements.NavigationBarView
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // TODO: Remove this
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: MainViewModel = MainViewModel(),
) {
    val context = LocalContext.current

    // BottomSheet states
    // TODO: Implement proper interaction with those states via ViewModel
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    val showBottomSheet = viewModel.showBottomSheet.collectAsState()

    val title by viewModel.habitTitleState.collectAsState()
    val contents by viewModel.habitContentState.collectAsState()

    Scaffold(
        modifier = Modifier
            .padding(top = Consts.paddingGlobalSmall)
            .fillMaxSize(),
        bottomBar = {
            NavigationBarView(
                currentScreenName = "home",
                onNavigationBarButtonClicked = {
                    if (!sheetState.isVisible) {
                        viewModel.onShowBottomSheetChanged()
                    }
                }
            )
        },
        topBar = {
            /* TODO: HomeView topBar */
        }
    ) {
        paddingValues ->

        Column {
            CalendarWeekCompactView(modifier = Modifier)

            Spacer(modifier = Modifier.padding(Consts.paddingLarge))

            val habitsList = viewModel.getAllHabits.collectAsState(initial = listOf())
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                items(items = habitsList.value, key = { habit -> habit.id }) { habit ->

                    HabitItemView(
                        habitData = habit,
                        onItemClick = {
                            val id = habit.id
                            // TODO: Implement EditView
                            navController.navigate(Destinations.EDIT_SCREEN + "/$id")
                        },
                        onButtonClick = {
                            // TODO: Functionality of the Button to the right. For now I think it
                            //  should be something like starring or pinning the Habit.
                            Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
        if (showBottomSheet.value) {
            // TODO: Move this ModalBottomSheet to a separate file and create a custom composable for it
            ModalBottomSheet(
                onDismissRequest = {
                    viewModel.onShowBottomSheetChanged()
                },
                sheetState = sheetState
            ) {
                // Sheet content
                Column(
                    modifier = Modifier
                        .padding(Consts.paddingMedium)
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        CustomTextField(
                            value = title,
                            onValueChange = { viewModel.onHabitTitleChanged(it) }
                        )
                    }

                    Spacer(modifier = Modifier.padding(Consts.paddingMedium))

                    // Button Save inside of the BottomSheet
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                viewModel.clearHabitTitle()
                                viewModel.addHabit(habitData = HabitData(title = title))

                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    viewModel.onShowBottomSheetChanged()
                                }
                            }
                                      },

                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(R.color.transparent),
                                contentColor = MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(text = "Save", style = MaterialTheme.typography.bodyLarge)
                        }
                    }

                    Spacer(modifier = Modifier.padding(Consts.paddingLarge))
                }
            }
        }

    }
}