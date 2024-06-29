package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Column
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
    val legendClasses = legends
        .groupBy { legend -> legend.legendClass }
        .map { classGroup ->
            Pair(classGroup.key, classGroup.value.sumOf { legend -> legend.wins })
        }
        .sortedByDescending { classWinsPair -> classWinsPair.second }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
    ) {
        item {
            Section(
                modifier = Modifier.fillMaxWidth(),
                title = "Wins by legend class",
                content = {
                    WinPieChart(
                        classWins = legendClasses,
                        strokeWidth = 16.dp,
                        modifier = Modifier.fillMaxWidth(),
                    )

                    Column {

                    }
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

    val legend3 = Legend(name = "Wow", icon = R.drawable.ash, legendClass = LegendClass.Controller)
    legend3.wins = 0

    val legend4 = Legend(name = "Chicken", icon = R.drawable.mirage, legendClass = LegendClass.Controller)
    legend4.wins = 2

    val legend5 = Legend(name = "Crow", icon = R.drawable.bloodhound, legendClass = LegendClass.Support)
    legend5.wins = 1

    WinStatsTab(
        legends = listOf(
            legend1,
            legend2,
            legend3,
            legend4,
            legend5
        )
    )
}