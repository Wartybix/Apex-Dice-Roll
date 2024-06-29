package com.example.apexdiceroll.ui.components.wins_screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R

@Composable
fun LegendClassWinsStat(
    modifier: Modifier = Modifier,
    legendClassName: String,
    legendClassWins: Int,
    lifetimeWins: Int,
    @DrawableRes legendClassIcon: Int ,
    legendClassOnColor: Color,
    legendClassColor: Color,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Surface(
            color = legendClassColor,
            contentColor = legendClassOnColor,
            shape = MaterialTheme.shapes.large
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = legendClassIcon),
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(Modifier.size(16.dp))

        Column {
            Text(text = legendClassName, style = MaterialTheme.typography.titleMedium)
            Text(
                text = stringResource(
                    id = R.string.apex_wins,
                    legendClassWins,
                    if (legendClassWins == 1) "" else "s"
                    //TODO make win and wins more translatable
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "${(legendClassWins.toFloat() / lifetimeWins * 100).toInt()}%",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview
@Composable
fun LegendClassWinsStatPreview() {
    LegendClassWinsStat(
        legendClassName = "Assault",
        legendClassWins = 10,
        lifetimeWins = 15,
        legendClassIcon = R.drawable.class_assault,
        legendClassOnColor = MaterialTheme.colorScheme.onPrimary,
        legendClassColor = MaterialTheme.colorScheme.primary
    )
}