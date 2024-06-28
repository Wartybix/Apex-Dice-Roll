package com.example.apexdiceroll.ui.components.diceroll_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameModeSwitcher(
    gameModeIdentifiers: List<String>,
    selectedGameMode: Int,
    randomGameMode: Boolean,
    onSwitch: (Int?) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            gameModeIdentifiers.forEachIndexed { index, identifier ->
                SegmentedButton(
                    selected = !randomGameMode && index == selectedGameMode,
                    onClick = {
                        if (randomGameMode || index != selectedGameMode) {
                            onSwitch(index)
                        }
                    },
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = gameModeIdentifiers.size + 1
                    )
                ) {
                    Text(text = identifier)
                }
            }

            SegmentedButton(
                selected = randomGameMode,
                onClick = {
                    if (!randomGameMode) {
                        onSwitch(null)
                    }
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index = gameModeIdentifiers.size,
                    count = gameModeIdentifiers.size + 1
                )
            ) {
                Text(text = stringResource(R.string.random))
            }
        }
    }
}

@Preview
@Composable
fun GameModeSwitcherPreview() {
    Surface {
        GameModeSwitcher(
            gameModeIdentifiers = listOf("Pigeon", "Hello"),
            selectedGameMode = 1,
            randomGameMode = true,
            onSwitch = {}
        )
    }

}