package com.example.apexdiceroll.ui.components.diceroll_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.data.GameMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameModeSwitcher(
    selectedGameMode: GameMode,
    randomGameMode: Boolean,
    onSwitch: (GameMode?) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val gameModes by remember { mutableStateOf(GameMode.entries) }

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            gameModes.forEachIndexed { index, gameMode ->
                SegmentedButton(
                    selected = !randomGameMode && gameMode == selectedGameMode,
                    onClick = {
                        if (randomGameMode || gameMode != selectedGameMode) {
                            onSwitch(gameMode)
                        }
                    },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = gameModes.size + 1)
                ) {
                    Text(text = gameMode.shortName)
                }
            }

            SegmentedButton(
                selected = randomGameMode,
                onClick = {
                    if (!randomGameMode) {
                        onSwitch(null)
                    }
                },
                shape = SegmentedButtonDefaults.itemShape(index = gameModes.size, count = gameModes.size + 1)
            ) {
                Text(text = "Random")
            }
        }
    }
}

@Preview
@Composable
fun GameModeSwitcherPreviewBR() {
    Surface {
        GameModeSwitcher(selectedGameMode = GameMode.BR, randomGameMode = true, onSwitch = {})
    }

}

@Preview
@Composable
fun GameModeSwitcherPreviewMixtape() {
    Surface {
        GameModeSwitcher(selectedGameMode = GameMode.Mixtape, randomGameMode = false, onSwitch = {})
    }
}