package com.example.habits2.uiElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.habits2.R
import com.example.habits2.screens.Consts

@Composable
fun NavigationBarView(
    currentScreenName: String,
    onNavigationBarButtonClicked: () -> Unit,
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // TODO: Create a custom NavigationBarItem so that you won't have to specify as many parameters for each item.

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Consts.paddingLarge, horizontal = Consts.paddingExtraLarge),
                horizontalArrangement = Arrangement.End
            ) {

                if (currentScreenName == "home") {
                    // FAB Add
                    FloatingActionButton(
                        onClick = { onNavigationBarButtonClicked() },
                        modifier = Modifier
                            .fillMaxHeight(),
                        shape = RoundedCornerShape(Consts.roundedCornerPercentageMedium),
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.primary,
                        elevation = FloatingActionButtonDefaults.elevation(Consts.elevationMedium) // This property doesn't seem to change anything
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Habit",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                if (currentScreenName == "edit") {
                    // Button "Mark Completed"
                    Button(
                        onClick = { onNavigationBarButtonClicked() },
                        modifier = Modifier.fillMaxHeight(),
                        shape = RoundedCornerShape(Consts.roundedCornerPercentageMedium),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.transparent),
                            contentColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = "Mark completed", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}