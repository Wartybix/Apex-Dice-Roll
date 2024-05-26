package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
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
import com.example.apexdiceroll.ui.theme.extendedDark
import com.example.apexdiceroll.ui.theme.extendedLight

@Composable
fun RosterScreen(
    legends: List<Legend>,
    legendsSelectionStatus: LegendsSelected,
    onToggleAll: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    val darkTheme = isSystemInDarkTheme()
    val colorFamily by remember { mutableStateOf(if (darkTheme) extendedDark else extendedLight) }

    Column(
        modifier = modifier.padding(paddingValues)
    ) {
        LazyColumn(
            modifier = modifier.weight(1f)
        ) {
            LegendClass.entries.forEach { legendClass ->
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    val classColour by remember {
                        mutableStateOf(
                            when (legendClass) {
                                LegendClass.Assault -> colorFamily.assault
                                LegendClass.Skirmisher -> colorFamily.skirmisher
                                LegendClass.Recon -> colorFamily.recon
                                LegendClass.Support -> colorFamily.support
                                LegendClass.Controller -> colorFamily.controller
                            }
                        )
                    }

                    Surface(
                        color = classColour.colorContainer,
                        contentColor = classColour.onColorContainer,
                        modifier = Modifier.padding(start = 24.dp),
                        shape = MaterialTheme.shapes.large
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = legendClass.icon),
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )

                            Spacer(modifier = Modifier.size(8.dp))

                            Text(text = legendClass.className, style = MaterialTheme.typography.titleSmall)
                        }
                    }

                    Spacer(modifier = Modifier.size(8.dp))
                }

                val classLegends = legends.filter { it.legendClass == legendClass }

                classLegends.forEachIndexed { index, legend ->
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