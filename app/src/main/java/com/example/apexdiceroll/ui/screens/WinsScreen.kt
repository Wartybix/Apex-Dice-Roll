package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.Win
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WinsScreen(
    modifier: Modifier = Modifier,
    wins: List<Win>
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val tabNames = listOf("History", "Edit")
    val scope = rememberCoroutineScope()

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
}

@Preview
@Composable
fun WinsScreenPreview() {
    WinsScreen(wins = listOf())
}
