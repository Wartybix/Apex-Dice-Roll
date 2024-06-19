package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.Win

@Composable
fun WinHistoryTab(modifier: Modifier = Modifier, wins: List<Win>) {
    LazyColumn(modifier = modifier) {
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
    WinHistoryTab(wins = listOf())
}