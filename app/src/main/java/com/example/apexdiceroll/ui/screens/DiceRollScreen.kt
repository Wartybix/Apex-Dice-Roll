package com.example.apexdiceroll.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.GameMode
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.MixtapeLoadout
import com.example.apexdiceroll.data.UpgradeSelection
import com.example.apexdiceroll.ui.components.diceroll_screen.GameModeSwitcher
import com.example.apexdiceroll.ui.components.diceroll_screen.legend_display.LegendCarousel
import com.example.apexdiceroll.ui.components.diceroll_screen.MixtapeLoadoutDisplay
import com.example.apexdiceroll.ui.components.diceroll_screen.RerollButton
import com.example.apexdiceroll.ui.components.diceroll_screen.SectionTitle
import com.example.apexdiceroll.ui.components.diceroll_screen.upgrades_area.UpgradesDisplay
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme

@Composable
fun DiceRollScreen(
    generatedLegends: List<Legend>,
    generatedMixtapeLoadout: MixtapeLoadout,
    generatedLegendUpgrades: List<UpgradeSelection>,
    selectedGameMode: GameMode,
    onGameModeSwitch: (GameMode) -> Unit,
    onReroll: () -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    val horizontalPadding by remember { mutableStateOf(24.dp) }
    val verticalPadding by remember { mutableStateOf(16.dp) }

    val startPadding by remember {
        mutableStateOf(
            horizontalPadding + paddingValues.calculateStartPadding(LayoutDirection.Ltr)
        )
    }
    val topPadding by remember {
        mutableStateOf(verticalPadding + paddingValues.calculateTopPadding())
    }
    val endPadding by remember {
        mutableStateOf(
            horizontalPadding + paddingValues.calculateEndPadding(LayoutDirection.Ltr)
        )
    }
    val bottomPadding by remember {
        mutableStateOf(verticalPadding + 8.dp + paddingValues.calculateBottomPadding())
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(top = topPadding, bottom = bottomPadding)
    ) {
        SectionTitle(text = "Game Mode")
        GameModeSwitcher(
            selectedGameMode = selectedGameMode,
            onSwitch = { onGameModeSwitch(it) },
            modifier = Modifier
                .padding(start = startPadding, end = endPadding)
                .fillMaxWidth()
        )
        Spacer(Modifier.size(32.dp))
        LegendCarousel(legendLoadout = generatedLegends)
        Spacer(Modifier.size(32.dp))
        when (selectedGameMode) {
            GameMode.BR -> {
                SectionTitle(text = "Legend Upgrades")
                UpgradesDisplay(
                    modifier = Modifier.padding(start = startPadding, end = endPadding),
                    data = generatedLegendUpgrades
                )
            }
            GameMode.Mixtape -> {
                SectionTitle(text = stringResource(id = R.string.mixtape_loadout))
                MixtapeLoadoutDisplay(
                    selectedLoadout = generatedMixtapeLoadout,
                    modifier = Modifier.padding(start = startPadding, end = endPadding)
                )
            }
        }
        Spacer(Modifier.height(32.dp))
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
                onGameModeSwitch = {},
                generatedMixtapeLoadout = MixtapeLoadout.CloseQuarters,
                generatedLegendUpgrades = listOf(UpgradeSelection.RIGHT, UpgradeSelection.LEFT)
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
                onGameModeSwitch = {},
                generatedMixtapeLoadout = MixtapeLoadout.CloseQuarters,
                generatedLegendUpgrades = listOf(UpgradeSelection.RIGHT, UpgradeSelection.LEFT)
            )
        }
    }
}