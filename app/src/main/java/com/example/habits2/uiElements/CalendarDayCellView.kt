package com.example.habits2.uiElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habits2.methods.getCurrentDate
import com.example.habits2.methods.getFormattedDate
import com.example.habits2.methods.getPastOrFutureDate
import com.example.habits2.screens.Consts
import java.util.Date
import java.util.Locale

@Composable
fun CalendarDayCellView(onClick: () -> Unit, daysOffset: Int) {

    val currentDate = getPastOrFutureDate(daysOffset)

    val formattedDateDay = getFormattedDate(currentDate, "dd") // Format as day only
    val formattedDateMonth = getFormattedDate(currentDate, "MMM") // Format as first three characters of the month name

    Box(modifier = Modifier.padding(PaddingValues(Consts.paddingSmall))){
        OutlinedButton(onClick = { /*TODO*/ },
            modifier= Modifier.size(Consts.fabSizeLarge),  //avoid the oval shape
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = formattedDateDay,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = formattedDateMonth.toString().uppercase(Locale.getDefault()),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
    getCurrentDate()
}

@Preview(showBackground = true)
@Composable
private fun CalendarDayCellViewPreview() {
    CalendarDayCellView(onClick = {}, daysOffset = 0)
}