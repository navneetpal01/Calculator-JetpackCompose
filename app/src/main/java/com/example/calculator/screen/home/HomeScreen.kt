package com.example.calculator.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.core.extension.currentFraction
import com.example.calculator.screen.component.main.MainContent
import com.example.calculator.screen.component.sheet.SheetContent
import com.example.calculator.ui.theme.BottomSheetBackground
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel : HomeViewModel = hiltViewModel()
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = SheetState(initialValue = SheetValue.PartiallyExpanded, skipPartiallyExpanded = false)
    )

    BottomSheet(
        state = scaffoldState
    ) {
        MainContent(
            fraction = scaffoldState.currentFraction,
            homeViewModel = homeViewModel
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    state: BottomSheetScaffoldState,
    mainContent: @Composable () -> Unit
) {

    val scope = rememberCoroutineScope()
    
    BottomSheetScaffold(
        scaffoldState = state,
        sheetPeekHeight = 24.dp,
        sheetContent = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .fillMaxWidth()
                    .fillMaxHeight(0.76f)
                    .background(BottomSheetBackground)
            ){
                SheetContent(
                    isExpanded = state.bottomSheetState.hasExpandedState,
                    onBack = {
                        scope.launch {
                            state.bottomSheetState.partialExpand()
                        }
                    }
                )
            }
        },
        sheetDragHandle = {

        },

        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        mainContent.invoke()
    }


}













