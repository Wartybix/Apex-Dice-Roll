package com.example.apexdiceroll.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.LegendClass

@Composable
fun LegendToggle(
    legendName: String,
    legendClass: LegendClass,
    wins: Int,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onToggle: (Boolean) -> Unit
) {
    val plural = if (wins == 1) "" else "s"

    ItemToggle(
        title = legendName,
        subtitle = stringResource(R.string.apex_wins, wins, plural),
        icon = ImageVector.vectorResource(legendClass.icon),
        iconDescription = legendClass.className,
        selected = selected,
        onToggle = onToggle,
        modifier = modifier
    )
}

@Preview
@Composable
fun LegendTogglePreview() {
    LegendToggle(
        legendName = "Octane",
        legendClass = LegendClass.Skirmisher,
        wins = 8,
        selected = true,
        onToggle = {}
    )
}

@Preview
@Composable
fun LegendTogglePreviewOneWin() {
    LegendToggle(
        legendName = "Ballistic",
        legendClass = LegendClass.Assault,
        wins = 1,
        selected = true,
        onToggle = {}
    )
}