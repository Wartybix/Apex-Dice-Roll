package com.example.apexdiceroll.ui.components.diceroll_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.data.MixtapeLoadout

@Composable
fun MixtapeLoadoutDisplay(
    selectedLoadout: MixtapeLoadout,
    modifier: Modifier = Modifier
) {
    val loadouts by remember { mutableStateOf(MixtapeLoadout.entries) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = selectedLoadout.loadoutName,
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            loadouts.forEachIndexed { index, loadout ->
                val colour = if (loadout == selectedLoadout)
                    MaterialTheme.colorScheme.onSurface
                else
                    MaterialTheme.colorScheme.surfaceContainerHighest

                Surface(
                    shape = CircleShape,
                    color = colour,
                    modifier = Modifier.size(8.dp),
                    content = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun MixtapeLoadoutDisplayPreviewSpecialist() {
    Surface {
        MixtapeLoadoutDisplay(MixtapeLoadout.Specialist)
    }
}

@Preview
@Composable
fun MixtapeLoadoutDisplayPreviewCQ() {
    Surface {
        MixtapeLoadoutDisplay(MixtapeLoadout.CloseQuarters)
    }
}