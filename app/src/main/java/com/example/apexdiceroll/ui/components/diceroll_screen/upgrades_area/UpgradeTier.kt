package com.example.apexdiceroll.ui.components.diceroll_screen.upgrades_area

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.UpgradeSelection
import com.example.apexdiceroll.ui.theme.ApexDiceRollTheme
import com.example.apexdiceroll.ui.theme.commonContainerDark
import com.example.apexdiceroll.ui.theme.commonContainerLight
import com.example.apexdiceroll.ui.theme.commonDark
import com.example.apexdiceroll.ui.theme.commonLight
import com.example.apexdiceroll.ui.theme.epicContainerDark
import com.example.apexdiceroll.ui.theme.epicContainerLight
import com.example.apexdiceroll.ui.theme.epicDark
import com.example.apexdiceroll.ui.theme.epicLight
import com.example.apexdiceroll.ui.theme.onCommonContainerDark
import com.example.apexdiceroll.ui.theme.onCommonContainerLight
import com.example.apexdiceroll.ui.theme.onCommonDark
import com.example.apexdiceroll.ui.theme.onCommonLight
import com.example.apexdiceroll.ui.theme.onEpicContainerDark
import com.example.apexdiceroll.ui.theme.onEpicContainerLight
import com.example.apexdiceroll.ui.theme.onEpicDark
import com.example.apexdiceroll.ui.theme.onEpicLight
import com.example.apexdiceroll.ui.theme.onRareContainerDark
import com.example.apexdiceroll.ui.theme.onRareContainerLight
import com.example.apexdiceroll.ui.theme.onRareDark
import com.example.apexdiceroll.ui.theme.onRareLight
import com.example.apexdiceroll.ui.theme.rareContainerDark
import com.example.apexdiceroll.ui.theme.rareContainerLight
import com.example.apexdiceroll.ui.theme.rareDark
import com.example.apexdiceroll.ui.theme.rareLight

@Composable
fun UpgradeTier(
    modifier: Modifier = Modifier,
    tier: Int,
    upgradeSelection: UpgradeSelection
) {
    val darkTheme = isSystemInDarkTheme()

    val chipColor by remember {
        mutableStateOf(
            when (tier) {
                2 -> if (darkTheme) rareDark else rareLight
                3 -> if (darkTheme) epicDark else epicLight
                else -> if (darkTheme) commonDark else commonLight
            }
        )
    }

    val tickColor by remember {
        mutableStateOf(
            when (tier) {
                2 -> if (darkTheme) onRareDark else onRareLight
                3 -> if (darkTheme) onEpicDark else onEpicLight
                else -> if (darkTheme) onCommonDark else onCommonLight
            }
        )
    }

    val containerColor by remember {
        mutableStateOf(
            when (tier) {
                2 -> if (darkTheme) rareContainerDark else rareContainerLight
                3 -> if (darkTheme) epicContainerDark else epicContainerLight
                else -> if (darkTheme) commonContainerDark else commonContainerLight
            }
        )
    }

    val onContainerColor by remember {
        mutableStateOf(
            when (tier) {
                2 -> if (darkTheme) onRareContainerDark else onRareContainerLight
                3 -> if (darkTheme) onEpicContainerDark else onEpicContainerLight
                else -> if (darkTheme) onCommonContainerDark else onCommonContainerLight
            }
        )
    }



    Row(modifier = modifier.height(IntrinsicSize.Min), verticalAlignment = Alignment.CenterVertically) {
        Upgrade(
            matchSurfaceColour = chipColor,
            matchOnSurfaceColor = tickColor,
            currentSelection = upgradeSelection,
            desiredSelection = UpgradeSelection.LEFT,
            modifier = Modifier.weight(1f)
        )
        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = containerColor,
            contentColor = onContainerColor
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text("LVL $tier", style = MaterialTheme.typography.labelSmall)
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.body_shield),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Upgrade(
            matchSurfaceColour = chipColor,
            matchOnSurfaceColor = tickColor,
            currentSelection = upgradeSelection,
            desiredSelection = UpgradeSelection.RIGHT,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun UpgradeTierPreview() {
    ApexDiceRollTheme {
        UpgradeTier(tier = 3, upgradeSelection = UpgradeSelection.RIGHT)
    }
}