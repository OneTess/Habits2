package com.example.habits2.uiElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
    // TODO: Customizable colors to accentuate the current day and only leave outlines of other days

    val currentDate = getPastOrFutureDate(daysOffset)

    val formattedDateDay = getFormattedDate(currentDate, "dd") // Format as day only
    val formattedDateMonth = getFormattedDate(currentDate, "MMM") // Format as first three characters of the month name

    Box(modifier = Modifier
        .padding(PaddingValues(Consts.paddingSmall))
    ){
        OutlinedButton(onClick = { /* TODO: Calendar cell onClick */ },
            // modifier= Modifier.size(Consts.fabSizeLarge),  // Avoid the oval shape
            shape = RoundedCornerShape(100),
            contentPadding = PaddingValues(
                top = Consts.paddingLarge,
                bottom = 18.dp
            ),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = formattedDateDay,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = formattedDateMonth.toString().uppercase(Locale.getDefault()),
                    style = MaterialTheme.typography.bodySmall
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