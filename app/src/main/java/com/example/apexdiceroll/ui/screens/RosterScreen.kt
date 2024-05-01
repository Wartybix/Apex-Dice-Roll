package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.LegendToggle

@Composable
fun RosterScreen(
    legends: List<Legend>,
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
                    wins = 0, //TODO Fix dummy value
                    selected = true, //TODO Fix dummy value
                    onToggle = {} //TODO Fix dummy value
                )
            }
        }

        HorizontalDivider()
        LegendToggle(
            selected = true, //TODO fix dummy value
            onToggle = {} //TODO fix dummy value
        )
    }

}

@Preview
@Composable
fun RosterScreenPreview() {
    RosterScreen(legends = listOf(
        Legend(name = "Revenant", icon = R.drawable.revenant, legendClass = LegendClass.Assault),
        Legend(name = "Pathfinder", icon = R.drawable.pathfinder, legendClass = LegendClass.Skirmisher)
    ))
}