package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.Win
import com.example.apexdiceroll.ui.components.wins_screen.EditWinsTab
import com.example.apexdiceroll.ui.components.wins_screen.WinHistoryTab
import com.example.apexdiceroll.ui.components.wins_screen.WinStatsTab
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WinsScreen(
    wins: List<Win>,
    legends: List<Legend>,
    paddingValues: PaddingValues = PaddingValues()
) {
    val tabNames = listOf(
        stringResource(R.string.history),
        stringResource(R.string.statistics),
        stringResource(R.string.edit)
    )
    val pagerState = rememberPagerState(pageCount = { tabNames.size })
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(paddingValues)) {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            tabNames.forEachIndexed { index, tabName ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(text = tabName) },
                    selectedContentColor = TabRowDefaults.primaryContentColor,
                    unselectedContentColor = TabRowDefaults.secondaryContentColor
                )
            }
        }

        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { index ->
            when (index) {
                0 -> {
                    val lifetimeWins by remember {
                        mutableIntStateOf(
                            legends.sumOf { it.wins }
                        )
                    }
                    WinHistoryTab(wins = wins, lifetimeWins = lifetimeWins)
                }
                1 -> { WinStatsTab(legends = legends) }
                2 -> { EditWinsTab(legends = legends) }
            }
        }
    }
}

@Preview
@Composable
fun WinsScreenPreview() {
    Surface {
        WinsScreen(wins = listOf(), legends = listOf())
    }
}
