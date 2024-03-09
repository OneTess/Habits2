package com.example.habits2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.habits2.uiElements.NavigationBarView

@Composable
fun ProfileView() {
    Scaffold(
        modifier = Modifier
            .padding(Consts.paddingMedium)
            .fillMaxHeight(),
        bottomBar = {
            Column {
                NavigationBarView(onShowBottomSheetClicked = {})
            }
        }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}