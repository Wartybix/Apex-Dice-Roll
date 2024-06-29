package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.shared.ContentUnavailableMessage
import com.example.apexdiceroll.ui.components.shared.Section
import com.example.apexdiceroll.ui.theme.extendedDark
import com.example.apexdiceroll.ui.theme.extendedLight

@Composable
fun WinStatsTab(
    modifier: Modifier = Modifier,
    legends: List<Legend>
) {
    val legendClasses by remember {
        mutableStateOf(
            legends
                .groupBy { legend -> legend.legendClass }
                .map { classGroup ->
                    Pair(classGroup.key, classGroup.value.sumOf { legend -> legend.wins })
                }
                .sortedByDescending { classWinsPair -> classWinsPair.second }
        )
    }

    val lifetimeWins = legendClasses.sumOf { it.second }

    val paddingValues by remember {
        mutableStateOf(PaddingValues(horizontal = 24.dp, vertical = 16.dp))
    }

    if (lifetimeWins > 0) {
        val darkTheme = isSystemInDarkTheme()
        val colorFamily by remember {
            mutableStateOf(if (darkTheme) extendedDark else extendedLight)
        }

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = paddingValues
        ) {
            item {
                Section(
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        WinPieChart(
                            classWins = legendClasses,
                            strokeWidth = 16.dp,
                            modifier = Modifier.fillMaxWidth(),
                        )

                        Spacer(modifier = Modifier.size(32.dp))

                        Column {
                            legendClasses.forEachIndexed { index, legendClass ->
                                val classColour = when (legendClass.first) {
                                    LegendClass.Assault -> colorFamily.assault
                                    LegendClass.Skirmisher -> colorFamily.skirmisher
                                    LegendClass.Recon -> colorFamily.recon
                                    LegendClass.Support -> colorFamily.support
                                    LegendClass.Controller -> colorFamily.controller
                                }

                                if (index > 0) {
                                    Spacer(modifier = Modifier.size(8.dp))
                                }

                                LegendClassWinsStat(
                                    legendClassName = legendClass.first.className,
                                    legendClassWins = legendClass.second,
                                    lifetimeWins = lifetimeWins,
                                    legendClassIcon = legendClass.first.icon,
                                    legendClassOnColor = classColour.onColor,
                                    legendClassColor = classColour.color
                                )
                            }
                        }
                    }
                )
            }
        }
    } else {
        ContentUnavailableMessage(
            imageVector = Icons.Outlined.QueryStats,
            text = stringResource(R.string.stats_will_show_here),
            hintMessage = "You can enter your existing wins in the ‘${stringResource(id = R.string.edit)}’ tab.",
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
fun WinStatsTabPreview() {
    val legend1 = Legend(
        name = "Yeah",
        icon = R.drawable.ballistic,
        legendClass = LegendClass.Assault
    )
    legend1.wins = 10

    val legend2 = Legend(
        name = "Pigeon",
        icon = R.drawable.bloodhound,
        legendClass = LegendClass.Recon
    )
    legend2.wins = 5

    val legend3 = Legend(
        name = "Wow",
        icon = R.drawable.ash,
        legendClass = LegendClass.Controller
    )
    legend3.wins = 0

    val legend4 = Legend(
        name = "Chicken",
        icon = R.drawable.mirage,
        legendClass = LegendClass.Controller
    )
    legend4.wins = 2

    val legend5 = Legend(
        name = "Crow",
        icon = R.drawable.bloodhound,
        legendClass = LegendClass.Support
    )
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

@Preview
@Composable
fun WinStatsTabPreviewNoWins() {
    WinStatsTab(legends = listOf())
}