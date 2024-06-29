package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
    var totalWins by remember { mutableIntStateOf(classWins.sumOf { it.second }) }

    Canvas(
        modifier = modifier,
        onDraw = {
            var startAngle = 0f

            classWins.forEach { pieSegment ->
                val legendClass = pieSegment.first

                val classColour = when (legendClass) {
                    LegendClass.Assault -> colorFamily.assault
                    LegendClass.Skirmisher -> colorFamily.skirmisher
                    LegendClass.Recon -> colorFamily.recon
                    LegendClass.Support -> colorFamily.support
                    LegendClass.Controller -> colorFamily.controller
                }

                var sweepAngle = (pieSegment.second.toFloat() / totalWins) * 360

                drawArc(
                    color = classColour.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(
                        width = strokeWidth.toPx()
                    )
                )

                startAngle += sweepAngle
            }
        }
    )
}

@Preview
@Composable
fun WinPieChartPreview() {
    WinPieChart(
        classWins = listOf(
            Pair(LegendClass.Controller, 2),
            Pair(LegendClass.Skirmisher, 10),
            Pair(LegendClass.Support, 5),
            Pair(LegendClass.Recon, 6),
            Pair(LegendClass.Assault, 3)
        ),
        modifier = Modifier.size(200.dp),
        strokeWidth = 24.dp
    )
}