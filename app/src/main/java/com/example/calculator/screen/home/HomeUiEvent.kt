package com.example.calculator.screen.home

import androidx.compose.ui.text.input.TextFieldValue


sealed interface HomeUiEvent{

    data class OnButtonAction(val symbol : String) : HomeUiEvent
    data class UpdateTextField(val value : TextFieldValue) : HomeUiEvent

}