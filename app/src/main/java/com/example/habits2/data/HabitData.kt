package com.example.habits2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class HabitData (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // TODO: Change id type to Long, maybe? Some errors will appear.

    val type: String = "",
    val progress: Int = 0,
    val goal: Int = 0,
    val title: String = "",
    val content: String = ""
)