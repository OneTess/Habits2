package com.example.habits2.uiElements

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel
import com.example.habits2.methods.autosaveProgress
import com.example.habits2.screens.Consts

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HabitItemView(
    habitData: HabitData,
    id: Int,
    viewModel: MainViewModel,
    onItemClick: () -> Unit,
    onButtonClick: () -> Unit,
    onCheckboxClick: () -> Unit
) {
    var checkedState = remember { mutableStateOf(false) }
    var testingCheckboxValue = viewModel.habitProgressState.value.toString()

    // Main Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Consts.paddingMedium)
            .clickable { onItemClick() },
        verticalAlignment = Alignment.Top
    ) {
        // TODO: Implement proper progress indicator dependent on the Habit type
        // Checkbox
        Checkbox(
            checked = checkedState.value, // TODO: Bind the checkedState to the actual db value.
            onCheckedChange = {
                var progress = habitData.progress
                checkedState.value = it
                // TODO: Is it acceptable to do it that way? I feel like there is something off
                //  with the way I am changing progress in the db. It works though, so I'll leave
                //  it for the time being.
                autosaveProgress(id = id, progress = viewModel.onHabitBinaryProgressChanged(progress), viewModel = viewModel)
            }
        )

        // Testing checkbox behaviour
        Text(text = "Progress: ${ habitData.progress }")
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "ID: $id")

        // Contents Column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .padding(
                    top = Consts.paddingLarge,
                    bottom = Consts.paddingLarge,
                    start = Consts.paddingExtraLarge,
                    end = Consts.paddingExtraLarge
                ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            // Title text field
            Text(
                text = habitData.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = Consts.fontSizeLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.padding(Consts.paddingExtraSmall))

            // Details text field
            Text(
                text = habitData.content,
                fontSize = Consts.fontSizeMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Star Button
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = { onButtonClick() }
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                imageVector = Icons.Outlined.Star,
                contentDescription = "Star this Habit"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitItemViewPreview() {
    HabitItemView(
        habitData = HabitData(title = "testing title", content = "testing content"),
        id = 1,
        viewModel = MainViewModel(),
        onItemClick = { },
        onButtonClick = { }
    ) {
        
    }
}