package com.example.calculator.core.extension

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue


@OptIn(ExperimentalMaterial3Api::class)
val BottomSheetScaffoldState.currentFraction : Float
    get() {
        val fraction = bottomSheetState.requireOffset()
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when{
            currentValue == SheetValue.Hidden && targetValue == SheetValue.Hidden -> 0f
            currentValue == SheetValue.Expanded && targetValue == SheetValue.Expanded-> 1f
            currentValue == SheetValue.Hidden && targetValue == SheetValue.Expanded -> fraction
            else -> 1f - fraction
        }
    }