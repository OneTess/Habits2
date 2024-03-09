package com.example.habits2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.habits2.data.MainViewModel
import com.example.habits2.uiElements.NavigationBarView
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // TODO: Remove this
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    viewModel: MainViewModel = MainViewModel(),
) {

    // BottomSheet states
    // TODO: Implement proper interaction with those states via ViewModel
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val showBottomSheet = viewModel.showBottomSheet.collectAsState()


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBarView()
        },
        topBar = {
            /* TODO: HomeView topBar */
        }
    ) {
        paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        viewModel.onShowBottomSheetChanged()
                    }
                }
            }) {
                Text(text = "Show bottom sheet")
            }
        }

        if (showBottomSheet.value) {
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
                    OutlinedTextField(
                        modifier = Modifier.padding(Consts.paddingMedium),
                        value = "Placeholder 1",
                        onValueChange = {})

                    OutlinedTextField(
                        modifier = Modifier.padding(Consts.paddingMedium),
                        value = "Placeholder 2",
                        onValueChange = {})

                    Button(onClick = {
                        /* TODO: Save functionality */
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                viewModel.onShowBottomSheetChanged()
                            }
                        }
                    }) {
                        Text(text = "Save")
                    }

                    Spacer(modifier = Modifier.padding(Consts.paddingLarge))
                }
            }
        }

    }
}