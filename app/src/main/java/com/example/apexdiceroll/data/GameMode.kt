package com.example.apexdiceroll.data

data class GameMode(
    val modeName: String,
    val shortName: String = modeName,
    val category: GameModeCategory,
    val teamSize: Int
)