package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Column
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
import com.example.apexdiceroll.data.Win
import com.example.apexdiceroll.ui.components.shared.Section

@Composable
fun WinHistoryTab(modifier: Modifier = Modifier, wins: List<Win>, lifetimeWins: Int) {
    LazyColumn(
        modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
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
        item {
            Spacer(modifier = Modifier.size(32.dp))
        }
        if (wins.isEmpty()) {
            item {
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.size(64.dp))
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
    Surface {
        WinHistoryTab(wins = listOf(), lifetimeWins = 50)
    }

}