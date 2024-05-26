package com.example.apexdiceroll.data

data class UiState(
    var generatedLegends: List<Legend> = emptyList(),
    var mixtapeLoadout: MixtapeLoadout = MixtapeLoadout.CloseQuarters,
    var legendUpgrades: List<UpgradeSelection> = emptyList(),
    var currentScreen: Screen = Screen.DiceRoll,
    var selectedGameMode: GameMode = GameMode.BR,
    var gameModeRandomised: Boolean = false,
)
