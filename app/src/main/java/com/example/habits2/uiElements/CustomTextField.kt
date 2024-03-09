package com.example.habits2.uiElements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.habits2.R
import com.example.habits2.screens.Consts

// TODO: Appearance of TextFields
// TODO: Behavior of TextFields such as autocorrect, capital letters etc.
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(textColor = colorResource(id = R.color.text_primary)),
        modifier = Modifier.padding(Consts.paddingMedium)
    )
}