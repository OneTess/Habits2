package com.example.habits2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_table")
data class HabitData (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "habit_id")
    val id: Int = 0, // TODO: Change id type to Long, maybe? Some errors will appear.

    @ColumnInfo(name = "habit_type")
    val type: String = "",

    @ColumnInfo(name = "habit_status")
    val status: Boolean = false,

    @ColumnInfo(name = "habit_progress")
    val progress: Int = 0,

    @ColumnInfo(name = "habit_goal")
    val goal: Int = 0,

    @ColumnInfo(name = "habit_title")
    val title: String = "",

    @ColumnInfo(name = "habit_content   ")
    val content: String = ""
)
