package com.example.habits2.data

import kotlinx.coroutines.flow.Flow

class HabitRepository(private val habitDao: HabitDao) {
    suspend fun updateHabitTitle(id: Int, title: String) {
        return habitDao.updateTitle(title, id)
    }

    suspend fun updateHabitProgress(id: Int, progress: Int) {
        return habitDao.updateProgress(progress, id)
    }

    suspend fun updateHabitGoal(id: Int, goal: Int) {
        return habitDao.updateGoal(goal, id)
    }

    suspend fun updateHabitStatus(id: Int, status: Boolean) {
        return habitDao.updateStatus(status, id)
    }



    fun getHabit(id: Int) : Flow<HabitData> {
        return habitDao.getHabit(id)
    }

    fun getAllHabits() : Flow<List<HabitData>> {
        return habitDao.getAllHabits()
    }

    suspend fun getBiggestId() : Int {
        return habitDao.getBiggestId()
    }



    suspend fun insertHabit(noteData: HabitData): Int {
        return habitDao.insert(noteData).toInt()
    }

    suspend fun deleteHabit(noteData: HabitData) {
        return habitDao.delete(noteData)
    }
}
