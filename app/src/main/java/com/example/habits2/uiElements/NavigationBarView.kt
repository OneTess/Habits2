package com.example.habits2.uiElements

import android.view.RoundedCorner
import android.view.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.example.habits2.screens.Consts

@Composable
fun NavigationBarView(onShowBottomSheetClicked: () -> Unit) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            // modifier = Modifier.padding(Consts.paddingMedium)
        ) {
            // TODO: Create a custom NavigationBarItem so that you won't have to specify as many parameters for each item.

            /*// Icon Home
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(Consts.iconSizeMedium)
                    )
                },
                label = { Text(text = "Home") },
                selected = false,
                onClick = { *//*TODO*//* },
                alwaysShowLabel = false
            )

            // Icon Habits
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Habits",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "Habits") },
                selected = false,
                onClick = { *//*TODO*//* },
                alwaysShowLabel = false
            )

            // Icon Reminders
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Reminders",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "Reminders") },
                selected = false,
                onClick = { *//*TODO*//* },
                alwaysShowLabel = false
            )

            // Icon Notes
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Create,
                        contentDescription = "Notes",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "Notes") },
                selected = false,
                onClick = { *//*TODO*//* },
                alwaysShowLabel = false
            )*/

            /*// Icon Profile
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "Profile") },
                selected = false,
                onClick = { *//*TODO*//* },
                alwaysShowLabel = false
            )*/

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Consts.paddingLarge, horizontal = Consts.paddingExtraLarge),
                horizontalArrangement = Arrangement.End
            ) {
                // FAB Add
                FloatingActionButton(
                    onClick = { onShowBottomSheetClicked() },
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
        }
    }
}