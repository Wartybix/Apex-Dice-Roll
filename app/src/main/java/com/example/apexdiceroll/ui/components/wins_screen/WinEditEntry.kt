package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R

@Composable
fun WinEditEntry(
    modifier: Modifier = Modifier,
    legendName: String,
    wins: Int,
    onEdit: (Int) -> Unit = {}
) {
    Row(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .heightIn(min = 48.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = legendName, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.weight(1f))

        TextField(
            value = wins.toString(),
            singleLine = true,
            modifier = Modifier.width(98.dp),
            onValueChange = { value ->
                onEdit(value.filter { char -> char.isDigit() }.toInt()) // Only accept integers
            },
            label = { Text(text = stringResource(id = R.string.wins)) }
        )

        Spacer(Modifier.size(8.dp))

        Column {
            IconButton(onClick = { onEdit(wins + 1) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Increment wins to ${wins + 1}"
                )
            }
            IconButton(onClick = { onEdit(wins - 1) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Decrement wins to ${wins - 1}"
                )
            }
        }

    }
}

@Preview
@Composable
fun LegendEditPreview() {
    Surface {
        WinEditEntry(legendName = "Wraith", wins = 5)
    }
}