package com.example.apexdiceroll.ui.components.roster_screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SelectAll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.LegendsSelected

@Composable
fun SelectAllToggle(
    modifier: Modifier = Modifier,
    selectionStatus: LegendsSelected,
    onToggle: (Boolean) -> Unit
) {
    ItemToggle(
        title = stringResource(id = R.string.select_all),
        icon = Icons.Default.SelectAll,
        iconDescription = null,
        selected = selectionStatus.value,
        onToggle = onToggle,
        modifier = modifier
    )
}

@Preview
@Composable
fun SelectAllTogglePreviewAll() {
    Surface {
        SelectAllToggle(selectionStatus = LegendsSelected.ALL, onToggle = {})
    }
}

@Preview
@Composable
fun SelectAllTogglePreviewSome() {
    Surface {
        SelectAllToggle(selectionStatus = LegendsSelected.SOME, onToggle = {})
    }
}

@Preview
@Composable
fun SelectAllTogglePreview() {
    Surface {
        SelectAllToggle(selectionStatus = LegendsSelected.NONE, onToggle = {})
    }
}