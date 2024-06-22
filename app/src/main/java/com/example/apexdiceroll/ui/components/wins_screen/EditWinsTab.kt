package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apexdiceroll.data.Legend

@Composable
fun EditWinsTab(modifier: Modifier = Modifier, legends: List<Legend>) {
    LazyColumn(modifier = modifier) {
        legends.forEachIndexed { index, legend ->
            if (index != 0) {
                item { HorizontalDivider() }
            }

            item {
                WinEditEntry(legendName = legend.name, wins = legend.wins)
            }
        }
    }
}