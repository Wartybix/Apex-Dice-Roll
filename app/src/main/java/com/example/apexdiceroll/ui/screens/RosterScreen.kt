package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.LegendsSelected
import com.example.apexdiceroll.ui.components.LegendToggle
import com.example.apexdiceroll.ui.components.SelectAllToggle

@Composable
fun RosterScreen(
    legends: List<Legend>,
    legendsSelectionStatus: LegendsSelected,
    onToggleAll: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    Column(
        modifier = modifier.padding(paddingValues)
    ) {
        LazyColumn(
            modifier = modifier.weight(1f)
        ) {
            itemsIndexed(legends) { index, legend ->
                if (index != 0) {
                    HorizontalDivider()
                }
                LegendToggle(
                    legendName = legend.name,
                    legendClass = legend.legendClass,
                    wins = legend.wins,
                    selected = legend.selected,
                    onToggle = { legend.selected = it },
                    modifier = Modifier
                )
            }
        }

        HorizontalDivider()

        SelectAllToggle(
            selectionStatus = legendsSelectionStatus,
            onToggle = onToggleAll,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }

}

@Preview
@Composable
fun RosterScreenPreview() {
    Surface {
        RosterScreen(
            legends = listOf(
                Legend(
                    name = "Revenant",
                    icon = R.drawable.revenant,
                    legendClass = LegendClass.Assault
                ),
                Legend(
                    name = "Pathfinder",
                    icon = R.drawable.pathfinder,
                    legendClass = LegendClass.Skirmisher
                )
            ),
            legendsSelectionStatus = LegendsSelected.ALL,
            onToggleAll = {}
        )
    }
}