package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.shared.LegendClassHeading

@Composable
fun EditWinsTab(modifier: Modifier = Modifier, legends: List<Legend>) {
    LazyColumn(modifier = modifier) {
        LegendClass.entries.forEach { legendClass ->
            item {
                LegendClassHeading(
                    legendClass = legendClass,
                    modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 8.dp)
                )
            }

            val classMembers = legends.filter { it.legendClass == legendClass }

            classMembers.forEachIndexed { index, legend ->
                if (index != 0) {
                    item { HorizontalDivider() }
                }

                item {
                    WinEditEntry(
                        legendName = legend.name,
                        wins = legend.wins,
                        onEdit = { legend.wins = it }
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun EditWinsTabPreview() {
    Surface {
        EditWinsTab(legends = listOf(
            Legend(name = "Alter", icon = R.drawable.alter, legendClass = LegendClass.Skirmisher)
        ))
    }

}