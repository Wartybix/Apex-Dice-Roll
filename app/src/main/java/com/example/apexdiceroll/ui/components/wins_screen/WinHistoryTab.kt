package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.Win
import java.util.Date

@Composable
fun WinHistoryTab(modifier: Modifier = Modifier, wins: List<Win>, lifetimeWins: Int) {
    val paddingValues by remember {
        mutableStateOf(PaddingValues(vertical = 16.dp, horizontal = 24.dp))
    }

    if (wins.isNotEmpty()) {
        LazyColumn(
            contentPadding = paddingValues
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
        Surface(color = Color.Transparent, contentColor = MaterialTheme.colorScheme.onSurfaceVariant) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.History,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Wins added with the '${stringResource(id = R.string.add_win)}' button will show here.",
                    style = MaterialTheme.typography.bodyLarge,
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