package com.example.habits2.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    // First state whether the search is happening or not
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    // Second state the text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    fun onSearchTextChanged(newString: String) {
        _searchText.value = newString
    }

    fun onSearchToggle() {
        _isSearching.value = !_isSearching.value
        if (!_isSearching.value) {
            onSearchTextChanged("")
        }
    }
}