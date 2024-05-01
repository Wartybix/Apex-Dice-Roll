package com.example.apexdiceroll.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SelectAll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme

@Composable
fun LegendToggle(
    legendName: String? = null,
    legendClass: LegendClass? = null,
    wins: Int? = null,
    selected: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth(),
    ) {
        val icon: ImageVector = if (legendClass != null) {
            ImageVector.vectorResource(legendClass.icon)
        } else {
            Icons.Default.SelectAll
        }

        val iconDescription = if (legendClass != null) {
            legendClass.className
        } else {
            null
        }

        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Column {
            val mainText = if (legendName != null) {
                legendName
            } else {
                stringResource(R.string.select_all)
            }

            Text(text = mainText, style = MaterialTheme.typography.titleMedium)

            if (wins != null) {
                Text(text = "$wins wins", style = MaterialTheme.typography.bodyMedium)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Checkbox(checked = selected, onCheckedChange = onToggle)
    }
}

@Preview
@Composable
fun LegendTogglePreview() {
    ApexDiceRollTheme {
        Surface {
            LegendToggle(
                legendName = "Bangalore",
                legendClass = LegendClass.Assault,
                wins = 9,
                selected = true,
                onToggle = {}
            )
        }
    }
}

@Preview
@Composable
fun SelectAllTogglePreview() {
    ApexDiceRollTheme {
        Surface {
            LegendToggle(
                selected = true,
                onToggle = {}
            )
        }
    }
}