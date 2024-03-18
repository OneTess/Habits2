package com.example.habits2.methods

import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel

fun autosaveTitle(
    id: Int,
    title: String,
    viewModel: MainViewModel,
) {
    viewModel.updateHabitTitle(id, title)
}

fun autosaveProgress(
    id: Int,
    progress: Int,
    viewModel: MainViewModel
) {
    viewModel.updateHabitProgress(id, progress)
}

fun autosaveStatus(
    id: Int,
    habitData: HabitData,
    viewModel: MainViewModel
) {
    viewModel.updateHabitStatus(id, habitData)
}