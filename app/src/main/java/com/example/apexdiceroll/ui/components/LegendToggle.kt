package com.example.apexdiceroll.ui.components

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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
    Card(modifier = modifier) {
        ItemToggle(
            title = legendName,
            subtitle = stringResource(R.string.apex_wins, wins),
            icon = ImageVector.vectorResource(legendClass.icon),
            iconDescription = legendClass.className,
            selected = selected,
            onToggle = onToggle
        )
    }
}