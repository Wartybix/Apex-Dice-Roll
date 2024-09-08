package com.example.apexdiceroll.data

data class UiState(
    var generatedLegends: List<Legend> = emptyList(),
    var mixtapeLoadout: MixtapeLoadout = MixtapeLoadout.CloseQuarters,
    var ltmLoadout: LTMLoadout = LTMLoadout.CloseQuarters,
    var legendUpgrades: List<UpgradeSelection> = emptyList(),
    var currentScreen: Screen = Screen.DiceRoll,
    var selectedGameModeIndex: Int = 0,
    var gameModeRandomised: Boolean = false,
)
