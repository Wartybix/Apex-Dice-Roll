package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.Win
import com.example.apexdiceroll.ui.components.shared.ContentUnavailableMessage
import java.util.Date

@Composable
fun WinHistoryTab(modifier: Modifier = Modifier, wins: List<Win>, lifetimeWins: Int) {
    val paddingValues by remember {
        mutableStateOf(PaddingValues(24.dp))
    }

    if (wins.isNotEmpty()) {
        LazyColumn(
            contentPadding = paddingValues,
            modifier = modifier
        ) {
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
    } else {
        ContentUnavailableMessage(
            imageVector = Icons.Default.History,
            text = stringResource(
                R.string.wins_added_will_show_here,
                stringResource(id = R.string.add_win)
            ),
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        )
    }
}

@Preview
@Composable
fun EmptyWinHistoryTabPreview() {
    Surface {
        WinHistoryTab(wins = listOf(), lifetimeWins = 50)
    }
}

@Preview
@Composable
fun WinHistoryTabPreview() {
    Surface {
        WinHistoryTab(
            wins = listOf(
                Win(
                    Legend(
                        name = "Revenant",
                        icon = R.drawable.revenant,
                        legendClass = LegendClass.Skirmisher
                    ),
                    date = Date(System.currentTimeMillis())
                )
            ),
            lifetimeWins = 1
        )
    }
}