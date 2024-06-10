package com.example.calculator.screen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.calculator.screen.home.HomeUiEvent
import com.example.calculator.screen.home.HomeUiState
import com.example.calculator.screen.home.HomeViewModel


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


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        ExpressionContent()
        Spacer(modifier = Modifier.height(72.dp))
        ButtonGrid()
    }


}