package com.example.habits2.uiElements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel
import com.example.habits2.screens.Consts

@Composable
fun HabitItemView(
    habitData: HabitData,
    onItemClick: () -> Unit,
    onButtonClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Consts.paddingMedium)
            .clickable { onItemClick() }
    ) {
        // TODO: Checkbox or a small circular progress indicator on the left
        Column(
            modifier = Modifier.padding(
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

            Row(
                modifier = Modifier
                    .heightIn(max = 28.dp)
                    .fillMaxWidth()
                    .padding(bottom = Consts.paddingSmall),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(
                    onClick = { onButtonClick() }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Outlined.Star,
                        contentDescription = "Star this Habit"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HabitItemViewPreview() {
    HabitItemView(habitData = HabitData(title = "testing title", content = "testing content"), onItemClick = { /*TODO*/ }) {
        
    }
}