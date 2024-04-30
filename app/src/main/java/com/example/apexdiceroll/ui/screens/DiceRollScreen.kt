package com.example.apexdiceroll.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.LegendCarousel
import com.example.apexdiceroll.ui.components.RerollButton

@Composable
fun DiceRollScreen(
    generatedLegends: List<Legend>,
    onReroll: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        LegendCarousel(legendLoadout = generatedLegends)
        RerollButton {
            onReroll
        }
    }
}

@Preview
@Composable
fun DiceRollScreenPreview() {
    DiceRollScreen(
        generatedLegends = listOf(
            Legend("Valkyrie", R.drawable.valk, LegendClass.Skirmisher),
            Legend("Mad Maggie", R.drawable.mad_maggie, LegendClass.Assault),
            Legend("Newcastle", R.drawable.newcastle, LegendClass.Support)
        ),
        onReroll = {}
    )
}