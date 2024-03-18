package com.example.habits2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A data class for storing info of every individual Habit item.
 *
 * [id] - A unique id for identifying Habits in the database
 *
 * [type] - Type of the Habit defining some of its properties - Mainly behaviour in the database:
 *
 * - **Binary** Habits can only be either done or not done.
 * - **Enumerable** Habits have a user-defined [goal] value and a [progress] value. (They all do, but
 * it only matters for **Enumerable**)
 *     - **Enumerable** Habits are only considered done when *progress* reaches *goal*.
 *
 * [status] - Boolean marking if the Habit is considered done. Its value is defined by the
 * logic described in the [type] block.
 *
 * TODO: Docstring: The rest of properties
 */
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
    val goal: Int = 1,

    @ColumnInfo(name = "habit_title")
    val title: String = "",

    @ColumnInfo(name = "habit_content")
    val content: String = ""
)
