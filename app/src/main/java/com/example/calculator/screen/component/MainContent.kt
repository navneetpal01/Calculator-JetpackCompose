package com.example.calculator.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.calculator.screen.home.HomeUiEvent
import com.example.calculator.screen.home.HomeUiState
import com.example.calculator.screen.home.HomeViewModel
import com.example.calculator.R



@Composable
fun MainContent(
    homeViewModel: HomeViewModel
) {
    val uiState by homeViewModel.uiState.collectAsState()

    MainContentImpl(
        uiState = uiState,
        onEvent = homeViewModel::onEvent
    )
}


@Composable
fun MainContentImpl(
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
            progress = ,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ExpressionContent()

            ButtonGrid()
        }
    }




}