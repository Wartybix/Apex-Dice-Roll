package com.example.apexdiceroll.data

data class UiState(
    var generatedLegends: List<Legend> = emptyList(),
    var currentScreen: Screen = Screen.DiceRoll
)
