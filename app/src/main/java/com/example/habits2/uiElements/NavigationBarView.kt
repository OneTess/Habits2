package com.example.habits2.uiElements

import android.view.RoundedCorner
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.ui.unit.dp
import com.example.habits2.screens.Consts

@Composable
fun NavigationBarView() {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier
            .wrapContentWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(100)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(Consts.paddingMedium)
        ) {
            // TODO: Create a custom NavigationBarItem so that you won't have to specify as many parameters for each item.

            // Icon Profile
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
                onClick = { /*TODO*/ },
                alwaysShowLabel = false
            )

            // Icon Calendar
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Calendar",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "Calendar") },
                selected = false,
                onClick = { /*TODO*/ },
                alwaysShowLabel = false
            )

            // Icon List
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.List,
                        contentDescription = "List",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "List") },
                selected = false,
                onClick = { /*TODO*/ },
                alwaysShowLabel = false
            )

            // Icon Add
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                },
                label = { Text(text = "Add") },
                selected = false,
                onClick = { /*TODO*/ },
                alwaysShowLabel = false
            )

            /*FloatingActionButton(
                onClick = {  },
                modifier = Modifier
                    .padding(Consts.paddingLarge)
                    .size(30.dp),
                shape = RoundedCornerShape(Consts.roundedCornerDpMedium),
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
                elevation = FloatingActionButtonDefaults.elevation(Consts.elevationMedium) // This property doesn't seem to change anything
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Habit", modifier = Modifier.size(24.dp))
            }*/
        }
    }
}