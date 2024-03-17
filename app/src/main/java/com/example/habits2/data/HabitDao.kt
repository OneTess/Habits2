package com.example.habits2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class HabitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(item: HabitData): Long

    @Query("UPDATE habit_table SET habit_title = :title WHERE habit_id = :id")
    abstract suspend fun updateTitle(title: String, id: Int)

    @Query("UPDATE habit_table SET habit_progress = :progress WHERE habit_id = :id")
    abstract suspend fun updateProgress(progress: Int, id: Int)

    @Delete
    abstract suspend fun delete(item: HabitData)

    @Query("SELECT * from habit_table WHERE habit_id = :id")
    abstract fun getHabit(id: Int): Flow<HabitData>

    @Query("SELECT * from habit_table WHERE habit_title != '' OR habit_content != '' ORDER BY habit_id DESC")
    abstract fun getAllHabits(): Flow<List<HabitData>>

    @Query("SELECT MAX(habit_id) from habit_table")
    abstract suspend fun getBiggestId(): Int
}
