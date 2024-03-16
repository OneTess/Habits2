package com.example.habits2.methods

import com.example.habits2.data.HabitData
import com.example.habits2.data.MainViewModel

fun autosaveAll(
    id: Int,
    viewModel: MainViewModel,
) {
    viewModel.editHabit(
        HabitData(
            id = id,
            title = viewModel.habitTitleState.value,
            content = viewModel.habitContentState.value,
        )
    )
}

fun autosaveProgress(
    id: Int,
    viewModel: MainViewModel
) {
    viewModel.editHabit(
        HabitData(
            id = id,
            progress = viewModel.habitProgressState.value
        )
    )
}