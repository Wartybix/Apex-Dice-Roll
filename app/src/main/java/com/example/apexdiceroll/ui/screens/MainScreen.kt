package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apexdiceroll.ui.ViewModel
import com.example.apexdiceroll.ui.components.LegendCarousel
import com.example.apexdiceroll.ui.components.RerollButton

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