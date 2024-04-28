package com.example.apexdiceroll.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: ViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    Column {
        LegendCarousel(legendLoadout = uiState.generatedLegends)
        RerollButton {
            viewModel.RollDice()
        }
    }

}