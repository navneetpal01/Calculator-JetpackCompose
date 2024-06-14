package com.example.calculator.screen.component.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun ExpressionContent(
    modifier: Modifier = Modifier,
    fraction : Float,
    currentExpression : TextFieldValue,
    result: String,
    updateTextFieldValue : (TextFieldValue) -> Unit
){

    val scrollstate = rememberScrollState()

    val customTextSelectionColors = TextSelectionColors(
        handleColor = Color.Transparent,
        backgroundColor = Color.LightGray
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(EXPRESSION_RESULT_HEIGHT),
        contentAlignment = Alignment.Center
    ){

    }
}

val EXPRESSION_RESULT_HEIGHT = 128.dp