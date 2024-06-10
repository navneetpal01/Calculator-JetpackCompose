package com.example.calculator.screen.component.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.calculator.screen.home.HomeUiEvent
import com.example.calculator.screen.home.HomeUiState
import com.example.calculator.screen.home.HomeViewModel
import com.example.calculator.R



@Composable
fun MainContent(
    fraction : Float,
    homeViewModel: HomeViewModel
) {
    val uiState by homeViewModel.uiState.collectAsState()

    MainContentImpl(
        fraction = fraction,
        uiState = uiState,
        onEvent = homeViewModel::onEvent
    )
}


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MainContentImpl(
    fraction : Float,
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit
) {

    val context = LocalContext.current

    //

    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
    ){
        MotionLayout(
            motionScene = MotionScene(content = motionScene),
            progress = fraction,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ExpressionContent(
                modifier = Modifier
                    .layoutId("expression_result"),
                currentExpression = uiState.currentExpression,
                result = uiState.result,
                updateTextFieldValue = {value ->
                    onEvent.invoke(HomeUiEvent.UpdateTextField(value))
                }
            )
            ButtonGrid(
                modifier = Modifier
                    .layoutId("button_grid")
                    .fillMaxWidth(),
                onActionClick = {symbol ->

                }
            )
        }
    }




}