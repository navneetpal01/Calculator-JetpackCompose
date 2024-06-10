package com.example.calculator.screen.component.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp


@Composable
fun ButtonGrid(
    modifier: Modifier = Modifier,
    onActionClick : (String) -> Unit
){
    val haptic = LocalHapticFeedback.current

    val buttons = listOf(
        listOf("AC","⌫","( )","÷"),
        listOf("7","8","9","x"),
        listOf("4","5","6","-"),
        listOf("1","2","3","+"),
        listOf("%","0",".","=")
    )
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){







    }
}