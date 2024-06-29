package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.ui.components.shared.LegendClassHeading
import com.example.apexdiceroll.ui.components.shared.Section

@Composable
fun EditWinsTab(modifier: Modifier = Modifier, legends: List<Legend>) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.how_to_find_legend_wins_tutorial),
                style = MaterialTheme.typography.bodySmall
            )
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))
        }
        item {
            Section(
                content = {
                    Row {
                        Icon(imageVector = Icons.Outlined.Info, contentDescription = null)
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(
                            text = stringResource(
                                R.string.manually_added_win_warning,
                                stringResource(id = R.string.add_win)
                            ),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                },
                color = MaterialTheme.colorScheme.tertiaryContainer
            )
        }
        item {
            Spacer(Modifier.size(16.dp))
        }
        LegendClass.entries.forEach { legendClass ->
            item {
                LegendClassHeading(
                    legendClass = legendClass,
                    modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
                )
            }

            val classMembers = legends.filter { it.legendClass == legendClass }

            classMembers.forEachIndexed { index, legend ->
                if (index > 0) {
                    item {
                        Spacer(modifier = Modifier.size(16.dp))
                    }
                }
                item {
                    WinEditEntry(
                        legendName = legend.name,
                        wins = legend.wins,
                        onEdit = { legend.wins = it }
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun EditWinsTabPreview() {
    Surface {
        EditWinsTab(legends = listOf(
            Legend(name = "Alter", icon = R.drawable.alter, legendClass = LegendClass.Skirmisher)
        ))
    }

}