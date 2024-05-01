package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.LegendToggle
import com.example.apexdiceroll.ui.components.SelectAllToggle

@Composable
fun RosterScreen(
    legends: List<Legend>,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    Column(
        modifier = modifier.padding(paddingValues)
    ) {
        val cardPadding = PaddingValues(horizontal = 24.dp)

        LazyColumn(
            modifier = modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            itemsIndexed(legends) { index, legend ->
                if (index != 0) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
                LegendToggle(
                    legendName = legend.name,
                    legendClass = legend.legendClass,
                    wins = 0, //TODO Fix dummy value
                    selected = true, //TODO Fix dummy value
                    onToggle = {}, //TODO Fix dummy value,
                    modifier = Modifier.padding(cardPadding)
                )
            }
        }

        HorizontalDivider()

        SelectAllToggle(
            selected = true, //TODO fix dummy value
            onToggle = {}, //TODO fix dummy value,
            modifier = Modifier
                .padding(cardPadding)
                .padding(vertical = 16.dp)
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