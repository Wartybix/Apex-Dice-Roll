package com.example.apexdiceroll.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SelectAll
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R

@Composable
fun SelectAllToggle(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onToggle: (Boolean) -> Unit
) {
    ElevatedCard(modifier = modifier) {
        ItemToggle(
            title = stringResource(id = R.string.select_all),
            icon = Icons.Default.SelectAll,
            iconDescription = null,
            selected = selected,
            onToggle = onToggle
        )
    }

}

@Preview
@Composable
fun SelectAllTogglePreview() {
    SelectAllToggle(selected = true, onToggle = {})
}