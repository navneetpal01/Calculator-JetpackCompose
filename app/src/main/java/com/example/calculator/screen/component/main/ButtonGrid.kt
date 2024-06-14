package com.example.calculator.screen.component.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.Blue
import com.example.calculator.ui.theme.DarkBackgroundColor
import com.example.calculator.ui.theme.Green
import com.example.calculator.ui.theme.Orange
import com.example.calculator.ui.theme.Red


@Composable
fun ButtonGrid(
    modifier: Modifier = Modifier,
    onActionClick: (String) -> Unit
) {
    val haptic = LocalHapticFeedback.current

    val buttons = listOf(
        listOf("AC", "⌫", "( )", "÷"),
        listOf("7", "8", "9", "x"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("%", "0", ".", "=")
    )
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        buttons.forEach { rowButtons ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowButtons.forEach {
                    ButtonComponent(
                        symbol = it,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { symbol ->
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                            onActionClick.invoke(symbol)
                        }
                    )
                }
            }

        }

    }
}

@Composable
private fun ButtonComponent(
    symbol: String,
    modifier: Modifier,
    onClick: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .background(buttonBackgroundColor(symbol))
            .then(modifier)
            .clickable { onClick.invoke(symbol) }
    ) {
        Text(
            text = symbol,
            fontSize = getButtonFontSize(symbol),
            color = Color.White
        )
    }
}


private fun buttonBackgroundColor(symbol: String): Color {
    return when (symbol) {
        "AC" -> Red
        "⌫" -> Green
        "=" -> Blue
        "( )", "÷", "x", "-", "+" -> Orange
        else -> DarkBackgroundColor
    }
}

private fun getButtonFontSize(symbol: String): TextUnit {
    return when (symbol) {
        "+", "x", "-", "+", "=" -> 38.sp
        else -> 24.sp
    }

}

















