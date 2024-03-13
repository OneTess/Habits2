package com.example.habits2.uiElements

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.habits2.R
import com.example.habits2.screens.Consts

// TODO: Behavior of TextFields such as autocorrect, capital letters etc.
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    // TODO: Visuals of TextField
    TextField(
        value = value,
        onValueChange = onValueChange
    )
}