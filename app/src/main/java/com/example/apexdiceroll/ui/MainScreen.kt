package com.example.apexdiceroll.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apexdiceroll.data.UiState

@Composable
fun MainScreen(
    viewModel: ViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    Column {
        LegendCarousel(legendLoadout = uiState.generatedLegends)
        Button(onClick = { viewModel.RollDice() }) {
            Text(text = "Re-roll")
        }
    }

}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}