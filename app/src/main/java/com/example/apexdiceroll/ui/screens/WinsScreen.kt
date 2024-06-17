package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.Win
import com.example.apexdiceroll.ui.components.wins_screen.WinCard

@Composable
fun WinsScreen(
    modifier: Modifier = Modifier,
    wins: List<Win>
) {
    LazyColumn {
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
fun WinsScreenPreview() {
    WinsScreen(wins = listOf())
}
