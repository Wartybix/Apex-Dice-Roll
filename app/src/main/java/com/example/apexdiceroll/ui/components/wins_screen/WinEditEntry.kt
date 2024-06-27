package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .heightIn(min = 48.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = legendName, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.weight(1f))

        var oldInput by remember {
            mutableIntStateOf(wins)
        }

        TextField(
            value = if (wins == 0) "" else wins.toString(),
            singleLine = true,
            modifier = Modifier.width(192.dp),
            onValueChange = { value ->
                val digitsEntered = value.filter { char -> char.isDigit() }
                onEdit(
                    if (digitsEntered == "") {
                        // If textbox empty, set wins to 0
                        0
                    }
                    else {
                        /* Otherwise set wins to textbox value -- only if it's an integer
                        AND doesn't overflow */
                        val sanitisedInteger = digitsEntered.toIntOrNull() ?: oldInput
                        oldInput = sanitisedInteger
                        sanitisedInteger
                    }


                )
            },
            label = { Text(text = stringResource(R.string.apex_wins_label)) },
            placeholder = { Text(text = stringResource(R.string.zero)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            leadingIcon = {
                IconButton(onClick = { onEdit(wins - 1) }) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Decrement wins to ${wins - 1}"
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { onEdit(wins + 1) }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Increment wins to ${wins + 1}"
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun LegendEditPreview() {
    Surface {
        WinEditEntry(legendName = "Wraith", wins = 5)
    }
}