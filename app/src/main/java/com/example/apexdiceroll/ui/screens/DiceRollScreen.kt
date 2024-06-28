package com.example.apexdiceroll.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.apexdiceroll.data.GameModeCategory
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.MixtapeLoadout
import com.example.apexdiceroll.data.UpgradeSelection
import com.example.apexdiceroll.ui.components.diceroll_screen.GameModeSwitcher
import com.example.apexdiceroll.ui.components.diceroll_screen.MixtapeLoadoutDisplay
import com.example.apexdiceroll.ui.components.diceroll_screen.legend_display.LegendCarousel
import com.example.apexdiceroll.ui.components.diceroll_screen.upgrades_area.UpgradesDisplay
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme

@Composable
fun DiceRollScreen(
    generatedLegends: List<Legend>,
    generatedMixtapeLoadout: MixtapeLoadout,
    generatedLegendUpgrades: List<UpgradeSelection>,
    gameModeIdentifiers: List<String>,
    selectedGameModeIndex: Int,
    selectedGameModeName: String,
    selectedGameModeCategory: GameModeCategory,
    gameModeRandomised: Boolean,
    onGameModeSwitch: (Int?) -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    //TODO remove use of Legend class
    val horizontalPadding by remember { mutableStateOf(24.dp) }

    val startPadding by remember {
        mutableStateOf(
            horizontalPadding + paddingValues.calculateStartPadding(LayoutDirection.Ltr)
        )
    }
    val topPadding by remember {
        mutableStateOf(16.dp + paddingValues.calculateTopPadding())
    }
    val endPadding by remember {
        mutableStateOf(
            horizontalPadding + paddingValues.calculateEndPadding(LayoutDirection.Ltr)
        )
    }
    val bottomPadding by remember {
        mutableStateOf(24.dp + paddingValues.calculateBottomPadding())
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(top = topPadding, bottom = bottomPadding)
    ) {
        GameModeSwitcher(
            gameModeIdentifiers = gameModeIdentifiers,
            selectedGameMode = selectedGameModeIndex,
            onSwitch = { newIndex ->
                onGameModeSwitch(newIndex)
            },
            randomGameMode = gameModeRandomised,
            modifier = Modifier
                .padding(start = startPadding, end = endPadding)
                .fillMaxWidth()
        )
        Spacer(Modifier.size(32.dp))

        if (gameModeRandomised) {
            Surface(
                shape = CardDefaults.shape,
                color = MaterialTheme.colorScheme.surfaceContainer,
                modifier = Modifier
                    .padding(horizontal = horizontalPadding)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.generated_game_mode),
                        style = MaterialTheme.typography.titleSmall
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = selectedGameModeName,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    Row {
                        Icon(
                            imageVector = Icons.Default.Balance,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.size(8.dp))

                        Text(
                            text = stringResource(
                                R.string.gamemode_category_equal_likelihood_message
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(32.dp))
        }

        LegendCarousel(legendLoadout = generatedLegends)
        Spacer(Modifier.size(32.dp))

        Surface(
            shape = CardDefaults.shape,
            color = MaterialTheme.colorScheme.surfaceContainer,
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = when (selectedGameModeCategory) {
                        GameModeCategory.BR -> stringResource(R.string.legend_upgrades)
                        GameModeCategory.MIXTAPE -> stringResource(R.string.mixtape_loadout)
                    },
                    style = MaterialTheme.typography.titleSmall
                )

                when (selectedGameModeCategory) {
                    GameModeCategory.BR -> {
                        UpgradesDisplay(data = generatedLegendUpgrades)
                    }
                    GameModeCategory.MIXTAPE -> {
                        MixtapeLoadoutDisplay(selectedLoadout = generatedMixtapeLoadout)
                    }
                }
            }
        }
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
                gameModeIdentifiers = listOf("Yay", "Ok", "Yeah"),
                selectedGameModeIndex = 1,
                selectedGameModeName = "Yay Wow",
                selectedGameModeCategory = GameModeCategory.BR,
                gameModeRandomised = false,
                onGameModeSwitch = {},
                generatedMixtapeLoadout = MixtapeLoadout.CloseQuarters,
                generatedLegendUpgrades = listOf(UpgradeSelection.RIGHT, UpgradeSelection.LEFT)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DiceRollScreenPreviewNightRandomised() {
    ApexDiceRollTheme {
        Surface {
            DiceRollScreen(
                generatedLegends = listOf(
                    Legend("Valkyrie", R.drawable.valk, LegendClass.Skirmisher),
                    Legend("Mad Maggie", R.drawable.mad_maggie, LegendClass.Assault),
                    Legend("Newcastle", R.drawable.newcastle, LegendClass.Support)
                ),
                gameModeIdentifiers = listOf("Yay", "Ok", "Yeah"),
                selectedGameModeIndex = 0,
                selectedGameModeName = "Yay Wow",
                selectedGameModeCategory = GameModeCategory.MIXTAPE,
                gameModeRandomised = true,
                onGameModeSwitch = {},
                generatedMixtapeLoadout = MixtapeLoadout.CloseQuarters,
                generatedLegendUpgrades = listOf(UpgradeSelection.RIGHT, UpgradeSelection.LEFT)
            )
        }
    }
}