package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.theme.extendedDark
import com.example.apexdiceroll.ui.theme.extendedLight

@Composable
fun WinPieChart(
    classWins: List<Pair<LegendClass, Int>>,
    modifier: Modifier = Modifier,
    strokeWidth: Dp
) {
    val darkTheme = isSystemInDarkTheme()
    val colorFamily by remember { mutableStateOf(if (darkTheme) extendedDark else extendedLight) }
    val classesWithWins by remember { mutableStateOf(classWins.filter { it.second > 0 }) }
    val totalWins by remember { mutableIntStateOf(classesWithWins.sumOf { it.second }) }

    Box(contentAlignment = Alignment.Center, modifier = modifier.size(192.dp)) {
        Canvas(
            modifier = Modifier.size(192.dp - strokeWidth),
            onDraw = {
                var startAngle = -90f
                val gapAngle = 12f
                val emptyCircleAngle = if (classesWithWins.size == 1)
                    0f
                else
                    classesWithWins.size * gapAngle
                val filledCircleAngle = 360f - emptyCircleAngle

                classesWithWins.forEach { pieSegment ->
                    val legendClass = pieSegment.first

                    val classColour = when (legendClass) {
                        LegendClass.Assault -> colorFamily.assault
                        LegendClass.Skirmisher -> colorFamily.skirmisher
                        LegendClass.Recon -> colorFamily.recon
                        LegendClass.Support -> colorFamily.support
                        LegendClass.Controller -> colorFamily.controller
                    }

                    val sweepAngle = (pieSegment.second.toFloat() / totalWins) * filledCircleAngle

                    drawArc(
                        color = classColour.color,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        useCenter = false,
                        style = Stroke(
                            width = strokeWidth.toPx(),
                            cap = StrokeCap.Round
                        )
                    )

                    startAngle += sweepAngle + (gapAngle)
                }
            }
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.lifetime_wins),
                style = MaterialTheme.typography.titleSmall
            )
            Text(text = totalWins.toString(), style = MaterialTheme.typography.titleLarge)
        }
    }

}

@Preview
@Composable
fun WinPieChartPreview() {
    WinPieChart(
        classWins = listOf(
            Pair(LegendClass.Controller, 0),
            Pair(LegendClass.Skirmisher, 10),
            Pair(LegendClass.Support, 5),
            Pair(LegendClass.Recon, 6),
            Pair(LegendClass.Assault, 3)
        ),
        strokeWidth = 16.dp,
    )
}