package com.example.apexdiceroll.ui.components.diceroll_screen.upgrades_area

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.data.UpgradeSelection
import com.example.apexdiceroll.ui.theme.onRareLight
import com.example.apexdiceroll.ui.theme.rareLight

@Composable
fun Upgrade(
    matchSurfaceColour: Color,
    matchOnSurfaceColor: Color,
    currentSelection: UpgradeSelection,
    desiredSelection: UpgradeSelection,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = if (currentSelection == desiredSelection) {
            matchSurfaceColour
        } else {
            MaterialTheme.colorScheme.surfaceContainerHighest
        },
        contentColor = matchOnSurfaceColor,
        modifier = modifier.fillMaxHeight()
    ) {
        if (currentSelection == desiredSelection) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val icon by remember { mutableStateOf(
                    when (currentSelection) {
                        UpgradeSelection.LEFT -> Icons.Default.ChevronLeft
                        UpgradeSelection.RIGHT -> Icons.Default.ChevronRight
                    }
                ) }
                Icon(
                    imageVector = icon,
                    contentDescription = currentSelection.description
                )
            }

        }
    }
}

@Preview
@Composable
fun UpgradeSelectionPreview() {
    Upgrade(
        matchSurfaceColour = rareLight,
        matchOnSurfaceColor = onRareLight,
        currentSelection = UpgradeSelection.LEFT,
        desiredSelection = UpgradeSelection.LEFT,
        modifier = Modifier.width(256.dp)
    )
}