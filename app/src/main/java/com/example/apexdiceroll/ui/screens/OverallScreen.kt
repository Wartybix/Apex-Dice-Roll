package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apexdiceroll.data.Screen
import com.example.apexdiceroll.ui.ViewModel
import com.example.apexdiceroll.ui.components.NavBar
import androidx.compose.ui.Modifier

@Composable
fun OverallScreen(
    viewModel: ViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    Column {
        when (uiState.currentScreen) {
            Screen.DiceRoll -> {
                DiceRollScreen(
                    generatedLegends = uiState.generatedLegends,
                    modifier = Modifier.weight(1f),
                    onReroll = {}
                )
            }

            Screen.LegendRoster -> { /*TODO*/ }
            Screen.WinHistory -> { /*TODO*/ }
        }

        NavBar(screen = uiState.currentScreen, onClick = { newScreen ->
            viewModel.switchScreen(newScreen)
        })
    }
}
