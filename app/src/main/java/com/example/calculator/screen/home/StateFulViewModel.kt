package com.example.calculator.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


open class StateFulViewModel<T>(
    initState: T
) : ViewModel() {

    private val _uiState = MutableStateFlow(initState)
    val uiState = _uiState.asStateFlow()


    protected fun updateUiState(newState: T.() -> T) {
        _uiState.update(newState)
    }



}