package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.shared.Section

@Composable
fun WinStatsTab(
    modifier: Modifier = Modifier,
    legends: List<Legend>
) {
    LazyColumn(modifier = modifier.fillMaxSize(), contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)) {
        item {
            Section(
                modifier = Modifier.fillMaxWidth(),
                title = "Wins by legend class",
                content = {
                    WinPieChart(
                        classWins = legends.map { legend -> Pair(legend.legendClass, legend.wins) },
                        strokeWidth = 16.dp,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun WinStatsTabPreview() {
    val legend1 = Legend(name = "Yeah", icon = R.drawable.ballistic, legendClass = LegendClass.Assault)
    legend1.wins = 10

    val legend2 = Legend(name = "Pigeon", icon = R.drawable.bloodhound, legendClass = LegendClass.Recon)
    legend2.wins = 5

    WinStatsTab(
        legends = listOf(
            legend1,
            legend2
        )
    )
}