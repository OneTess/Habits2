package com.example.habits2

import android.content.Context
import androidx.room.Room
import com.example.habits2.data.HabitDatabase
import com.example.habits2.data.HabitRepository

object Graph {
    private lateinit var database: HabitDatabase

    val habitRepository by lazy {
        HabitRepository(habitDao = database.habitDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, HabitDatabase::class.java, "habits.db").fallbackToDestructiveMigration().build()
    }
}
