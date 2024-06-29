package com.example.apexdiceroll.ui.components.roster_screen

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R

@Composable
fun LegendToggle(
    legendName: String,
    wins: Int,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val plural by remember { mutableStateOf(if (wins == 1) "" else "s") }

    ItemToggle(
        title = legendName,
        subtitle = stringResource(R.string.apex_wins, wins, plural),
        icon = null,
        iconDescription = null,
        selected = selected,
        onToggle = onToggle,
        modifier = modifier
    )
}

@Preview
@Composable
fun LegendTogglePreview() {
    Surface {
        LegendToggle(
            legendName = "Octane",
            wins = 8,
            selected = true,
            onToggle = {}
        )
    }
}

@Preview
@Composable
fun LegendTogglePreviewOneWin() {
    Surface {
        LegendToggle(
            legendName = "Ballistic",
            wins = 1,
            selected = true,
            onToggle = {}
        )
    }
}