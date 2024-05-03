package com.example.apexdiceroll.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apexdiceroll.data.Screen
import com.example.apexdiceroll.ui.ViewModel
import com.example.apexdiceroll.ui.components.overall_screen.NavBar
import com.example.apexdiceroll.ui.components.overall_screen.TopAppBar

@Composable
fun OverallScreen(
    viewModel: ViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    Scaffold(
        topBar = { TopAppBar() },
        content = { it ->
            when (uiState.currentScreen) {
                Screen.DiceRoll -> {
                    DiceRollScreen(
                        generatedLegends = uiState.generatedLegends,
                        generatedMixtapeLoadout = uiState.mixtapeLoadout,
                        onReroll = { viewModel.rollDice() },
                        selectedGameMode = uiState.selectedGameMode,
                        onGameModeSwitch = {
                            viewModel.switchGameMode(it)
                            viewModel.rollDice()
                        },
                        paddingValues = it
                    )
                }

                Screen.LegendRoster -> {
                    RosterScreen(
                        legends = viewModel.legendRoster,
                        legendsSelectionStatus = viewModel.getRosterSelectionStatus(),
                        onToggleAll = { viewModel.rosterToggleAll(it) },
                        paddingValues = it)
                }

                Screen.WinHistory -> { /*TODO*/ }
            }
        },
        bottomBar = {
            NavBar(screen = uiState.currentScreen, onClick = { newScreen ->
                viewModel.switchScreen(newScreen)
            })
        }
    )
}
