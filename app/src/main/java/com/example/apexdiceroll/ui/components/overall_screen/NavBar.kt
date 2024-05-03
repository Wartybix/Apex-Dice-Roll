package com.example.apexdiceroll.ui.components.overall_screen

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Screen
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme

@Composable
fun NavBar(
    screen: Screen,
    onClick: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {

        @Composable
        fun ApexDiceRollItem(
            destinationScreen: Screen,
            filledIcon: ImageVector,
            outlinedIcon: ImageVector,
            label: String
        ) {
            val isSelected = screen == destinationScreen
            val iconImageVector = if (isSelected)
                filledIcon
            else
                outlinedIcon

            NavigationBarItem(
                selected = isSelected,
                onClick = { onClick(destinationScreen) },
                icon = { Icon(imageVector = iconImageVector, contentDescription = null) },
                label = { Text(label) }
            )
        }
        
        ApexDiceRollItem(
            destinationScreen = Screen.DiceRoll,
            filledIcon = Icons.Filled.Casino,
            outlinedIcon = Icons.Outlined.Casino,
            label = stringResource(R.string.dice_roll)
        )

        ApexDiceRollItem(
            destinationScreen = Screen.LegendRoster,
            filledIcon = Icons.Filled.People,
            outlinedIcon = Icons.Outlined.People,
            label = stringResource(R.string.roster)
        )

        ApexDiceRollItem(
            destinationScreen = Screen.WinHistory,
            filledIcon = Icons.Filled.History,
            outlinedIcon = Icons.Outlined.History,
            label = stringResource(R.string.win_history)
        )
    }
}

@Preview
@Composable
fun NavBarPreviewDiceRoll() {
    ApexDiceRollTheme {
        NavBar(screen = Screen.DiceRoll, onClick = {})
    }
}

@Preview
@Composable
fun NavBarPreviewRoster() {
    ApexDiceRollTheme {
        NavBar(screen = Screen.LegendRoster, onClick = {})
    }
}