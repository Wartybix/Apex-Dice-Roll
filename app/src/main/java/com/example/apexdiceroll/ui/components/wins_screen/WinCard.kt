package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandCircleDown
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import java.util.Date

@Composable
fun WinCard(winnerName: String, winnerClass: LegendClass, winDate: Date) {
    val darkTheme = isSystemInDarkTheme()
    val colourFamily by remember { mutableStateOf(if (darkTheme) extendedDark else extendedLight) }

    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                val classColour by remember {
                    mutableStateOf(
                        when (winnerClass) {
                            LegendClass.Assault -> colourFamily.assault
                            LegendClass.Skirmisher -> colourFamily.skirmisher
                            LegendClass.Recon -> colourFamily.recon
                            LegendClass.Support -> colourFamily.support
                            LegendClass.Controller -> colourFamily.controller
                        }
                    )
                }

                Surface(
                    color = classColour.color,
                    contentColor = classColour.onColor,
                    shape = MaterialTheme.shapes.large
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(winnerClass.icon),
                        contentDescription = winnerClass.className,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.size(16.dp))


                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = winnerName, style = MaterialTheme.typography.titleLarge)
                    Text(text = winDate.toLocaleString(), style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(imageVector = Icons.Default.ExpandCircleDown, contentDescription = "Expand")
            }

            Spacer(modifier = Modifier.size(16.dp))

            Button(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Remove")
            }
        }

    }
}

@Preview
@Composable
fun WinCardPreview() {
    WinCard(winnerName = "Ballistic", winnerClass = LegendClass.Assault, winDate = Date(1))
}