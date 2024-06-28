package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.Win
import com.example.apexdiceroll.ui.components.shared.Section
import java.util.Date

@Composable
fun WinHistoryTab(modifier: Modifier = Modifier, wins: List<Win>, lifetimeWins: Int) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Section(
                    title = "Lifetime Wins",
                    content = {
                        Text(lifetimeWins.toString(), style = MaterialTheme.typography.titleLarge)
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            if (wins.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.size(32.dp))
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

        if (wins.isEmpty()) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Wins added with the '${stringResource(id = R.string.add_win)}' button will show here.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
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