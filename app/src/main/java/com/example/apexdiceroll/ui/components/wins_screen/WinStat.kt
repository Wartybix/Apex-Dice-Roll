package com.example.apexdiceroll.ui.components.wins_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R

@Composable
fun WinStat(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    iconContentDescription: String?,
    iconColor: Color? = null,
    iconOnColor: Color? = null,
    wins: Int,
    rankingMessage: String? = null,
    rankingBorder: Boolean = false
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (iconColor == null || iconOnColor == null) {
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = iconColor,
                contentColor = iconOnColor
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = iconContentDescription,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                )
            }
        }

        Spacer(Modifier.size(16.dp))

        Column {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(
                text = stringResource(id = R.string.apex_wins, wins, if (wins == 1) "" else "s"),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        if (rankingMessage != null) {
            if (rankingBorder) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceContainerHighest,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = rankingMessage,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                Text(text = rankingMessage, style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}

@Preview
@Composable
fun WinStatPreview() {
    Surface {
        WinStat(
            title = "My Title",
            icon = Icons.Outlined.Cloud,
            iconColor = MaterialTheme.colorScheme.primary,
            iconOnColor = MaterialTheme.colorScheme.onPrimary,
            iconContentDescription = null,
            wins = 5,
            rankingMessage = "50%"
        )
    }
}

@Preview
@Composable
fun WinStatPreviewWithRanking() {
    Surface {
        WinStat(
            title = "My Title",
            icon = Icons.Outlined.Cloud,
            iconContentDescription = null,
            wins = 5,
            rankingMessage = "#1",
            rankingBorder = true
        )
    }
}