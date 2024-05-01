package com.example.apexdiceroll.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
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
    legends: SnapshotStateList<Legend>,
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
                    wins = legend.wins,
                    selected = legend.selected,
                    onToggle = { legend.selected = it },
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

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun RosterScreenPreview() {
    RosterScreen(legends = mutableStateListOf(
        Legend(name = "Revenant", icon = R.drawable.revenant, legendClass = LegendClass.Assault),
        Legend(name = "Pathfinder", icon = R.drawable.pathfinder, legendClass = LegendClass.Skirmisher)
    )
    )
}