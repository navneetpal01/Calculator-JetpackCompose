package com.example.calculator.screen.home

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel : StateFulViewModel<HomeUiState>(HomeUiState()) {



    fun onEvent(event : HomeUiEvent){
        viewModelScope.launch(Dispatchers.IO){
            when(event){
                is HomeUiEvent.OnButtonAction -> {}
                is HomeUiEvent.UpdateTextField -> {}
            }
        }
    }

}