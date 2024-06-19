package com.example.apexdiceroll.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.Win

@Composable
fun WinsScreen(
    modifier: Modifier = Modifier,
    wins: List<Win>
) {

}

@Preview
@Composable
fun WinsScreenPreview() {
    WinsScreen(wins = listOf())
}
