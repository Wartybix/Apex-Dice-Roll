package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.Win

@Composable
fun WinHistoryTab(modifier: Modifier = Modifier, wins: List<Win>, lifetimeWins: Int) {
    LazyColumn(modifier = modifier) {
        item {
            Text(text = lifetimeWins.toString())
        }
        wins.forEach { win ->
            item {
                WinCard(
                    winnerName = win.legend.name,
                    winnerClass = win.legend.legendClass,
                    winDate = win.date
                )
            }
        }
    }
}

@Preview
@Composable
fun WinHistoryTabPreview() {
    WinHistoryTab(wins = listOf(), lifetimeWins = 50)
}