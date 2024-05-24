package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.LegendsSelected
import com.example.apexdiceroll.ui.components.roster_screen.LegendToggle
import com.example.apexdiceroll.ui.components.roster_screen.SelectAllToggle

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
            items(LegendClass.entries) { legendClass ->
                Spacer(modifier = Modifier.height(16.dp))

                Column {
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(start = 24.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = legendClass.icon),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.size(8.dp))

                            Text(text = legendClass.className, style = MaterialTheme.typography.titleMedium)
                        }
                    }

                    Spacer(modifier = Modifier.size(8.dp))

                    Column {
                        val classLegends = legends.filter { it.legendClass == legendClass }

                        classLegends.forEachIndexed { index, legend ->
                            if (index != 0) {
                                HorizontalDivider()
                            }
                            LegendToggle(
                                legendName = legend.name,
                                legendClass = legend.legendClass,
                                wins = legend.wins,
                                selected = legend.selected,
                                onToggle = { legend.selected = it }
                            )
                        }
                    }
                }

            }
            
//            itemsIndexed(legends) { index, legend ->
//                if (index != 0) {
//                    HorizontalDivider()
//                }
//                LegendToggle(
//                    legendName = legend.name,
//                    legendClass = legend.legendClass,
//                    wins = legend.wins,
//                    selected = legend.selected,
//                    onToggle = { legend.selected = it }
//                )
//            }
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