package com.example.calculator.screen.component.main

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp


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
        Column(
            modifier = Modifier
                .padding(end = 24.dp),
            horizontalAlignment = Alignment.End
        ){
            CompositionLocalProvider(
                LocalTextSelectionColors provides customTextSelectionColors,
                LocalTextInputService provides null
            ) {
                BasicTextField(
                    value = currentExpression,
                    onValueChange = updateTextFieldValue,
                    textStyle = TextStyle(
                        letterSpacing = 2.sp,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                    ),
                    modifier = Modifier
                        .horizontalScroll(
                            state = scrollstate,
                            reverseScrolling = true
                        ),
                    maxLines = 1,
                    cursorBrush = SolidColor(Color.Cyan),
                    readOnly = false
                )
            }
        }
    }
}

val EXPRESSION_RESULT_HEIGHT = 128.dp