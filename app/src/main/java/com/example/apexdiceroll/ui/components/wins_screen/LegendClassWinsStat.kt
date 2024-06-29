package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R

@Composable
fun LegendClassWinsStat(
    modifier: Modifier = Modifier,
    legendClassName: String,
    legendClassWins: Int,
    lifetimeWins: Int,
    legendClassIcon: ImageVector,
    legendClassOnColor: Color,
    legendClassColor: Color,
) {
    WinStat(
        modifier = modifier,
        title = legendClassName,
        icon = legendClassIcon,
        iconContentDescription = null,
        iconColor = legendClassColor,
        iconOnColor = legendClassOnColor,
        wins = legendClassWins,
        rankingMessage = "${(legendClassWins.toFloat() / lifetimeWins * 100).toInt()}%"

    )
}

@Preview
@Composable
fun LegendClassWinsStatPreview() {
    Surface {
        LegendClassWinsStat(
            legendClassName = "Assault",
            legendClassWins = 10,
            lifetimeWins = 15,
            legendClassIcon = ImageVector.vectorResource(id = R.drawable.class_assault),
            legendClassOnColor = MaterialTheme.colorScheme.onPrimary,
            legendClassColor = MaterialTheme.colorScheme.primary
        )
    }
}