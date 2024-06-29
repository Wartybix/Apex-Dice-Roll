package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.LegendsSelected
import com.example.apexdiceroll.ui.components.roster_screen.LegendToggle
import com.example.apexdiceroll.ui.components.roster_screen.SelectAllToggle
import com.example.apexdiceroll.ui.components.shared.LegendClassHeading

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
            item {
                Text(
                    text = stringResource(R.string.uncheck_legends_tutorial),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(24.dp)
                )
            }
            LegendClass.entries.forEachIndexed { index, legendClass ->
                if (index > 0) {
                    item { Spacer(modifier = Modifier.size(16.dp)) }
                }
                item {
                    LegendClassHeading(
                        legendClass = legendClass,
                        modifier = Modifier.padding(start = 24.dp, bottom = 8.dp)
                    )
                }

                val classMembers = legends.filter { it.legendClass == legendClass }

                classMembers.forEachIndexed { index, legend ->
                    item {
                        if (index != 0)
                            HorizontalDivider()

                        LegendToggle(
                            legendName = legend.name,
                            wins = legend.wins,
                            selected = legend.selected,
                            onToggle = { legend.selected = it }
                        )
                    }
                }
            }
        }


        HorizontalDivider()

        SelectAllToggle(
            selectionStatus = legendsSelectionStatus,
            onToggle = onToggleAll
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