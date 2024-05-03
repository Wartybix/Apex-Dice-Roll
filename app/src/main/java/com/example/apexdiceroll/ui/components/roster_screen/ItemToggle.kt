package com.example.apexdiceroll.ui.components.roster_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R

//TODO put loading icons in a coroutine.

@Composable
fun ItemToggle(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    iconDescription: String?,
    subtitle: String? = null,
    selected: Boolean?,
    onToggle: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable(
                role = Role.Checkbox,
                onClick = {
                    onToggle(if (selected == null) true else !selected)
                }
            )
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .heightIn(min = 48.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Column {
            Text(text = title, style = MaterialTheme.typography.titleMedium)

            if (subtitle != null) {
                Text(text = subtitle, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        TriStateCheckbox(
            state = when (selected) {
                true -> ToggleableState.On
                false -> ToggleableState.Off
                else -> ToggleableState.Indeterminate
            },
            onClick = null
        )
    }

}

@Preview
@Composable
fun ItemTogglePreview() {
    Surface {
        ItemToggle(title = "Hello World",
            icon = ImageVector.vectorResource(R.drawable.class_skirmisher),
            iconDescription = null,
            selected = true,
            onToggle = {}
        )
    }

}