package com.example.apexdiceroll.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.MixtapeLoadout

@Composable
fun MixtapeLoadoutDisplay(
    selectedLoadout: MixtapeLoadout,
    modifier: Modifier = Modifier
) {
    val loadouts = MixtapeLoadout.entries
    val padding = 8.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.mixtape_loadout),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.size(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            loadouts.forEachIndexed { index, loadout ->
                if (index != 0) {
                    Spacer(modifier = Modifier.size(padding))
                }

                if (loadout == selectedLoadout) {
                    Surface(
                        shape = MaterialTheme.shapes.large,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = selectedLoadout.loadoutName,
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                else {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.surfaceContainer,
                        modifier = Modifier.size(24.dp)
                    ) {

                    }
                }
            }
        }
    }


}

@Preview
@Composable
fun MixtapeLoadoutDisplayPreview() {
    Surface {
        MixtapeLoadoutDisplay(MixtapeLoadout.Specialist)
    }

}