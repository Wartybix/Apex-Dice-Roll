package com.example.apexdiceroll.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apexdiceroll.R
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
        floatingActionButton = {
            when (uiState.currentScreen) {
                Screen.DiceRoll -> {
                    FloatingActionButton(
                        onClick = { viewModel.rollDice() }
                    ) {
                        Icon(imageVector = Icons.Default.Sync, contentDescription = stringResource(R.string.re_roll))
                    }
                }
                Screen.WinHistory -> {
                    ExtendedFloatingActionButton(
                        onClick = { /*TODO*/ },
                        icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                        text = { Text(stringResource(R.string.add_win)) }
                    )
                }
		        else -> {}
            }
        },
        content = { it ->
            when (uiState.currentScreen) {
                Screen.DiceRoll -> {
                    DiceRollScreen(
                        generatedLegends = uiState.generatedLegends,
                        generatedMixtapeLoadout = uiState.mixtapeLoadout,
                        generatedLegendUpgrades = uiState.legendUpgrades,
                        selectedGameMode = uiState.selectedGameMode,
                        gameModeRandomised = uiState.gameModeRandomised,
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

                Screen.WinHistory -> {
                    WinsScreen(wins = listOf(), paddingValues = it /*TODO change*/)
                }
            }
        },
        bottomBar = {
            NavBar(screen = uiState.currentScreen, onClick = { newScreen ->
                viewModel.switchScreen(newScreen)
            })
        }
    )
}
