package com.example.apexdiceroll.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.GameMode
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.GameModeSwitcher
import com.example.apexdiceroll.ui.components.LegendCarousel
import com.example.apexdiceroll.ui.components.RerollButton
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme

@Composable
fun DiceRollScreen(
    generatedLegends: List<Legend>,
    selectedGameMode: GameMode,
    onGameModeSwitch: (GameMode) -> Unit,
    onReroll: () -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    val horizontalPadding = 24.dp
    val verticalPadding = 32.dp

    val startPadding = horizontalPadding + paddingValues.calculateStartPadding(LayoutDirection.Ltr)
    val topPadding = verticalPadding + paddingValues.calculateTopPadding()
    val endPadding = horizontalPadding + paddingValues.calculateEndPadding(LayoutDirection.Ltr)
    val bottomPadding = verticalPadding + paddingValues.calculateBottomPadding()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = topPadding, bottom = bottomPadding)
    ) {
        GameModeSwitcher(
            selectedGameMode = selectedGameMode,
            onSwitch = { onGameModeSwitch(it) },
            modifier = Modifier
                .padding(start = startPadding, end = endPadding)
                .fillMaxWidth()
        )
        Spacer(Modifier.size(32.dp))
        LegendCarousel(legendLoadout = generatedLegends)
        Spacer(Modifier.weight(1f))
        RerollButton(onClick = onReroll)
    }
}

@Preview
@Composable
fun DiceRollScreenPreview() {
    ApexDiceRollTheme {
        Surface {
            DiceRollScreen(
                generatedLegends = listOf(
                    Legend("Valkyrie", R.drawable.valk, LegendClass.Skirmisher),
                    Legend("Mad Maggie", R.drawable.mad_maggie, LegendClass.Assault),
                    Legend("Newcastle", R.drawable.newcastle, LegendClass.Support)
                ),
                onReroll = {},
                selectedGameMode = GameMode.BR,
                onGameModeSwitch = {}
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DiceRollScreenPreviewDark() {
    ApexDiceRollTheme {
        Surface {
            DiceRollScreen(
                generatedLegends = listOf(
                    Legend("Valkyrie", R.drawable.valk, LegendClass.Skirmisher),
                    Legend("Mad Maggie", R.drawable.mad_maggie, LegendClass.Assault),
                    Legend("Newcastle", R.drawable.newcastle, LegendClass.Support)
                ),
                onReroll = {},
                selectedGameMode = GameMode.BR,
                onGameModeSwitch = {}
            )
        }
    }
}