package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.Win
import com.example.apexdiceroll.ui.components.wins_screen.EditWinsTab
import com.example.apexdiceroll.ui.components.wins_screen.WinHistoryTab
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WinsScreen(
    wins: List<Win>,
    paddingValues: PaddingValues = PaddingValues()
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val tabNames = listOf("History", "Edit")
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
                    text = { Text(text = tabName) }
                )
            }
        }

        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { index ->
            when (index) {
                0 -> { WinHistoryTab(wins = wins) }
                1 -> { EditWinsTab() }
            }
        }
    }
}

@Preview
@Composable
fun WinsScreenPreview() {
    WinsScreen(wins = listOf())
}
