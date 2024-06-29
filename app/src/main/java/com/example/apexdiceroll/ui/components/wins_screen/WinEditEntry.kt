package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
        modifier = modifier.heightIn(min = 48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = legendName, style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.weight(1f))

        var oldInput by remember {
            mutableIntStateOf(wins)
        }

        OutlinedTextField(
            value = if (wins == 0) "" else wins.toString(),
            singleLine = true,
            modifier = Modifier.width(206.dp),
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
                IconButton(
                    onClick = { onEdit(wins - 1) },
                    enabled = wins > 0
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = stringResource(R.string.decrement_win)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = { onEdit(wins + 1) },
                    enabled = wins < Int.MAX_VALUE
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.increment_win)
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