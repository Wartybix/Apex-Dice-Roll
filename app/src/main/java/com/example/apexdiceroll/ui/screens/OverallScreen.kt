package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
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

    val localDensity = LocalDensity.current
    var fabHeight by remember { mutableStateOf(0.dp) }

    Scaffold(
        topBar = { TopAppBar() },
        floatingActionButton = {
            when (uiState.currentScreen) {
                Screen.DiceRoll -> {
                    FloatingActionButton(
                        onClick = { viewModel.rollDice() },
                        modifier = Modifier.onGloballyPositioned { coordinates ->
                            fabHeight = with (localDensity) { coordinates.size.height.toDp() }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Sync, contentDescription = "Re-Roll")
                    }
                }
                Screen.WinHistory -> {
                    ExtendedFloatingActionButton(
                    onClick = { /*TODO*/ },
                    icon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                    text = { Text("Add Win") }
                    )
                    //TODO add fab height modifier
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
                        onGameModeSwitch = {
                            viewModel.switchGameMode(it)
                            viewModel.rollDice()
                        },
                        paddingValues = it,
                        modifier = Modifier.padding(bottom = fabHeight)
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
