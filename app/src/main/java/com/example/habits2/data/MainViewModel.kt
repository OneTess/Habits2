package com.example.habits2.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habits2.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class MainViewModel(private val habitRepository: HabitRepository = Graph.habitRepository) : ViewModel() {
    private val _habitTitleState = MutableStateFlow("")
    private val _habitContentState = MutableStateFlow("")
    private val _habitTypeState = MutableStateFlow("")
    private val _habitProgressState = MutableStateFlow(0)
    private val _showBottomSheet = MutableStateFlow(false)

    private val _habitDataState = MutableStateFlow(HabitData())

    val habitTitleState: StateFlow<String> = _habitTitleState
    val habitContentState: StateFlow<String> = _habitContentState
    val habitTypeState: StateFlow<String> = _habitTypeState
    val habitProgressState: StateFlow<Int> = _habitProgressState
    val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

    val habitDataState: StateFlow<HabitData> = _habitDataState

    var idMax by mutableStateOf(0)

    lateinit var getAllHabits: Flow<List<HabitData>>

    init {
        getAllHabits = habitRepository.getAllHabits()
        // TODO: Get rid of all unused methods
        /*viewModelScope.launch {
            @OptIn(FlowPreview::class)
            _habitDataState.debounce(100).collect(::updateHabitTitle)
        }*/
    }

    fun onHabitBinaryProgressChanged() {
        if (_habitProgressState.value == 0) {
            _habitProgressState.value = 1
        } else {
            _habitProgressState.value = 0
        }
        // updateHabitTitle(HabitData(progress = _habitProgressState.value))
    }

    /*fun debounceAndSaveHabitData(delayMillis: Long = 500) {
        viewModelScope.launch {
            _habitDataState.debounce(delayMillis).collect { habitData ->
                updateHabitTitle(id, title)
                _habitDataState.value = HabitData() // Reset temporary state
            }
        }
    }*/

    fun onHabitTitleChanged(newString: String) {
        _habitTitleState.value = newString
    }

    fun clearHabitTitle() {
        _habitTitleState.value = ""
    }

    fun onHabitContentsChanged(newString: String) {
        _habitContentState.value = newString
    }

    fun onHabitTypeChanged(newString: String) {
        _habitTypeState.value = newString
    }

    fun onHabitProgressChanged(newProgressValue: Int) {
        _habitProgressState.value = newProgressValue
    }

    fun onShowBottomSheetChanged() {
        _showBottomSheet.value = _showBottomSheet.value != true
    }

    fun addHabit(habitData: HabitData) {
        viewModelScope.launch(Dispatchers.IO) {
            idMax = habitRepository.insertHabit(habitData)
        }
    }

    fun updateHabitTitle(id: Int, title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            habitRepository.updateHabitTitle(id, title)
        }
    }

    fun updateHabitProgress(id: Int, progress: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            habitRepository.updateHabitProgress(id, progress)
        }
    }

    fun deleteHabit(habit: HabitData) {
        viewModelScope.launch(Dispatchers.IO) {
            habitRepository.deleteHabit(habit)
        }
    }

    fun getHabit(id: Int): Flow<HabitData> {
        return habitRepository.getHabit(id)
    }

    fun getAllHabits(): Flow<List<HabitData>> {
        return habitRepository.getAllHabits()
    }
}
