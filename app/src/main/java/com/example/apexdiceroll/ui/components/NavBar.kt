package com.example.apexdiceroll.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.outlined.Casino
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.People
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Screen
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme

@Composable
fun NavBar(
    screen: Screen,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        NavigationBarItem(
            selected = screen == Screen.DiceRoll,
            onClick = { /*TODO*/ },
            icon = {
                if (screen == Screen.DiceRoll)
                    Icon(imageVector = Icons.Filled.Casino, contentDescription = null)
                else
                    Icon(imageVector = Icons.Outlined.Casino, contentDescription = null)
            },
            label = { Text(stringResource(R.string.dice_roll)) }
        )

        NavigationBarItem(
            selected = screen == Screen.LegendRoster,
            onClick = { /*TODO*/ },
            icon = {
                if (screen == Screen.LegendRoster)
                    Icon(imageVector = Icons.Filled.People, contentDescription = null)
                else
                    Icon(imageVector = Icons.Outlined.People, contentDescription = null)
            },
            label = { Text(stringResource(R.string.legend_roster)) }
        )

        NavigationBarItem(
            selected = screen == Screen.WinHistory,
            onClick = { /*TODO*/ },
            icon = {
                if (screen == Screen.LegendRoster)
                    Icon(imageVector = Icons.Filled.History, contentDescription = null)
                else
                    Icon(imageVector = Icons.Outlined.History, contentDescription = null)
            },
            label = { Text(stringResource(R.string.win_history)) }
        )
    }
}

@Preview
@Composable
fun NavBarPreviewDiceRoll() {
    ApexDiceRollTheme {
        NavBar(screen = Screen.DiceRoll)
    }
}

@Preview
@Composable
fun NavBarPreviewRoster() {
    ApexDiceRollTheme {
        NavBar(screen = Screen.LegendRoster)
    }
}