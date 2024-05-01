package com.example.apexdiceroll.data

data class UiState(
    var generatedLegends: List<Legend> = emptyList(),
    var mixtapeLoadout: MixtapeLoadout = MixtapeLoadout.CloseQuarters,
    var currentScreen: Screen = Screen.DiceRoll,
    var selectedGameMode: GameMode = GameMode.BR
)
