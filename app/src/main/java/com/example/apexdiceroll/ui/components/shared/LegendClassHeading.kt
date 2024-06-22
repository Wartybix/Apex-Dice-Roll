package com.example.apexdiceroll.ui.components.shared

import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.theme.extendedDark
import com.example.apexdiceroll.ui.theme.extendedLight

@Composable
fun LegendClassHeading(modifier: Modifier = Modifier, legendClass: LegendClass) {
    val darkTheme = isSystemInDarkTheme()
    val colorFamily by remember { mutableStateOf(if (darkTheme) extendedDark else extendedLight) }
    val classColour by remember {
        mutableStateOf(
            when (legendClass) {
                LegendClass.Assault -> colorFamily.assault
                LegendClass.Skirmisher -> colorFamily.skirmisher
                LegendClass.Recon -> colorFamily.recon
                LegendClass.Support -> colorFamily.support
                LegendClass.Controller -> colorFamily.controller
            }
        )
    }

    Column(modifier = modifier) {
        Surface(
            color = classColour.colorContainer,
            contentColor = classColour.onColorContainer,
            shape = MaterialTheme.shapes.large
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = legendClass.icon),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(text = legendClass.className, style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}

@Preview
@Composable
fun AssaultHeadingPreview() {
    LegendClassHeading(legendClass = LegendClass.Assault)
}

@Preview
@Composable
fun SkirmisherHeadingPreview() {
    LegendClassHeading(legendClass = LegendClass.Skirmisher)
}

@Preview
@Composable
fun ReconHeadingPreview() {
    LegendClassHeading(legendClass = LegendClass.Recon)
}

@Preview
@Composable
fun SupportHeadingPreview() {
    LegendClassHeading(legendClass = LegendClass.Support)
}

@Preview
@Composable
fun ControllerHeadingPreview() {
    LegendClassHeading(legendClass = LegendClass.Controller)
}