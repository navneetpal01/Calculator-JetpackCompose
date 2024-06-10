package com.example.calculator.screen.home

import androidx.compose.ui.text.input.TextFieldValue


data class HomeUiState(
    val currentExpression : TextFieldValue = TextFieldValue(text = ""),
    val result : String = ""
)