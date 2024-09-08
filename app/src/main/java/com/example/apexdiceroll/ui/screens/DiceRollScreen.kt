package com.example.apexdiceroll.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
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
import com.example.apexdiceroll.data.LTMLoadout
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.MixtapeLoadout
import com.example.apexdiceroll.data.UpgradeSelection
import com.example.apexdiceroll.ui.components.diceroll_screen.GameModeSwitcher
import com.example.apexdiceroll.ui.components.diceroll_screen.MixtapeLoadoutDisplay
import com.example.apexdiceroll.ui.components.diceroll_screen.legend_display.LegendCarousel
import com.example.apexdiceroll.ui.components.diceroll_screen.upgrades_area.UpgradesDisplay
import com.example.apexdiceroll.ui.components.shared.Section
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme
import com.example.apexdiceroll.ui.theme.extendedDark
import com.example.apexdiceroll.ui.theme.extendedLight

@Composable
fun DiceRollScreen(
    generatedLegends: List<Legend>,
    generatedMixtapeLoadout: MixtapeLoadout,
    generatedLTMLoadout: LTMLoadout,
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

    val darkMode = isSystemInDarkTheme()

    val colorFamily = if (darkMode) extendedDark else extendedLight

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(top = topPadding, bottom = bottomPadding),
        verticalArrangement = Arrangement.spacedBy(24.dp)
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

        if (gameModeRandomised) {
            Section(
                title = stringResource(id = R.string.generated_game_mode),
                content = {
                    Text(
                        text = selectedGameModeName,
                        style = MaterialTheme.typography.titleLarge
                    )

//                    Spacer(modifier = Modifier.size(16.dp))
//
//                    Row {
//                        Icon(
//                            imageVector = Icons.Default.Balance,
//                            contentDescription = null
//                        )
//
//                        Spacer(modifier = Modifier.size(16.dp))
//
//                        Text(
//                            text = stringResource(
//                                R.string.gamemode_category_equal_likelihood_message
//                            ),
//                            style = MaterialTheme.typography.bodySmall
//                        )
//                    }
                },
                modifier = Modifier
                    .padding(horizontal = horizontalPadding)
                    .fillMaxWidth()
            )
        }

        LegendCarousel(legendLoadout = generatedLegends)

        Row(
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (selectedGameModeCategory) {
                GameModeCategory.BR ->
                    Section(
                        title = stringResource(R.string.legend_upgrades),
                        content = {
                            UpgradesDisplay(data = generatedLegendUpgrades)
                        }
                    )
                GameModeCategory.MIXTAPE -> {
                    Section(
                        title = stringResource(R.string.mixtape_loadout),
                        content = {
                            MixtapeLoadoutDisplay(
                                selectedLoadout = generatedMixtapeLoadout.loadoutName,
                                loadoutRoster = MixtapeLoadout.entries.map { it.loadoutName },
                                selectedColor = MaterialTheme.colorScheme.onSurface,
                                unselectedColor = MaterialTheme.colorScheme.surfaceContainerHighest
                            )
                        },
                        modifier = Modifier.weight(1f)
                    )
                    Section(
                        title = "LTM Loadout",
                        content = {
                            MixtapeLoadoutDisplay(
                                selectedLoadout = generatedLTMLoadout.loadoutName,
                                loadoutRoster = LTMLoadout.entries.map { it.loadoutName },
                                selectedColor = colorFamily.legendary.onColorContainer,
                                unselectedColor = colorFamily.legendary.onColor
                            )
                        },
                        color = colorFamily.legendary.colorContainer,
                        contentColor = colorFamily.legendary.onColorContainer,
                        modifier = Modifier.weight(1f)
                    )
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
                generatedLTMLoadout = LTMLoadout.Assault,
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
                generatedLTMLoadout = LTMLoadout.Assault,
                generatedLegendUpgrades = listOf(UpgradeSelection.RIGHT, UpgradeSelection.LEFT)
            )
        }
    }
}