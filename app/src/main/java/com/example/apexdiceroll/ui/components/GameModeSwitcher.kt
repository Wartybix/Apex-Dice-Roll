package com.example.apexdiceroll.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.data.GameMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameModeSwitcher(
    selectedGameMode: GameMode,
    onSwitch: (GameMode) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Game Mode", style = MaterialTheme.typography.titleSmall)
        val gameModes = GameMode.entries

        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            gameModes.forEachIndexed { index, gameMode ->
                SegmentedButton(
                    selected = gameMode == selectedGameMode,
                    onClick = { onSwitch(gameMode) },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = gameModes.size)
                ) {
                    Text(text = gameMode.modeName)
                }
            }
        }
    }
}

@Preview
@Composable
fun GameModeSwitcherPreviewBR() {
    Surface {
        GameModeSwitcher(selectedGameMode = GameMode.BR, onSwitch = {})
    }

}

@Preview
@Composable
fun GameModeSwitcherPreviewMixtape() {
    Surface {
        GameModeSwitcher(selectedGameMode = GameMode.Mixtape, onSwitch = {})
    }
}