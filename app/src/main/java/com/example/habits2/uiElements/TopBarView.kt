package com.example.habits2.uiElements

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.habits2.screens.Consts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarView(
    currentScreen: String,
    onBackNavClicked: () -> Unit = { },
    onDeleteClick: () -> Unit = { }
) {
    val navigationButtonComposable : (@Composable () -> Unit) = {
        if (!currentScreen.contains("home")){
            IconButton(onClick = { onBackNavClicked() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back button"
                    // In case there are some display issues, you could try adding the tint property
                )
            }
        } else {
            null
        }
    }

    TopAppBar(
        title = { Text(text = "Testing Title") },
        colors = TopAppBarDefaults.topAppBarColors(),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(end = Consts.paddingMedium),
        navigationIcon = { navigationButtonComposable() },
        actions = {
            if (currentScreen.contains("edit")){
                var expanded by remember { mutableStateOf(false) }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(100))
                        .clickable { expanded = !expanded },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Dropdown Menu",
                        // In case there are some display issues, you could try adding the tint property
                    )
                    // TODO: Does the app even need this DropdownMenu?
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {
                        // Item Delete
                        DropdownMenuItem(
                            text = { Text(text = "Delete") },
                            onClick = {
                                Log.d("EditView_DropdownMenu", "Pressed ItemDelete")
                                onDeleteClick()
                            }
                        )
                    }
                }
            }
        }
    )
}