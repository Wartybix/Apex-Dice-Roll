package com.example.apexdiceroll.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.data.LegendClass

@Composable
fun LegendToggle(
    legendName: String,
    legendClass: LegendClass,
    wins: Int,
    selected: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(legendClass.icon),
            contentDescription = legendClass.className,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(text = legendName, style = MaterialTheme.typography.titleMedium)
            Text(text = "$wins wins")
        }

        Checkbox(checked = selected, onCheckedChange = onToggle)
    }
}

@Preview
@Composable
fun LegendTogglePreview() {
    LegendToggle(legendName = "Bangalore", legendClass = LegendClass.Assault, wins = 9, selected = true, onToggle = {})
}