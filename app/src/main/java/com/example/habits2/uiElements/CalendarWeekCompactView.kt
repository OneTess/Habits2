package com.example.habits2.uiElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.habits2.screens.Consts

@Composable
fun CalendarWeekCompactView(modifier: Modifier) {
    // TODO: Put this inside the LazyRow, maybe?

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CalendarDayCellView(onClick = {  }, daysOffset = -2)

        CalendarDayCellView(onClick = {  }, daysOffset = -1)

        CalendarDayCellView(onClick = {  }, daysOffset = 0)

        CalendarDayCellView(onClick = {  }, daysOffset = 1)

        CalendarDayCellView(onClick = {  }, daysOffset = 2)
    }
}