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
import com.example.apexdiceroll.ui.theme.extendedDark
import com.example.apexdiceroll.ui.theme.extendedLight

@Composable
fun UpgradeTier(
    modifier: Modifier = Modifier,
    tier: Int,
    upgradeSelection: UpgradeSelection
) {
    val darkTheme = isSystemInDarkTheme()

    val colorFamily by remember { mutableStateOf(if (darkTheme) extendedDark else extendedLight) }

    val rarity by remember {
        mutableStateOf(
            when (tier) {
                1 -> colorFamily.common
                2 -> colorFamily.rare
                3 -> colorFamily.epic
                4 -> colorFamily.legendary
                5 -> colorFamily.mythic
                else -> colorFamily.common
            }
        )
    }



    Row(modifier = modifier.height(IntrinsicSize.Min), verticalAlignment = Alignment.CenterVertically) {
        Upgrade(
            matchSurfaceColour = rarity.color,
            matchOnSurfaceColor = rarity.onColor,
            currentSelection = upgradeSelection,
            desiredSelection = UpgradeSelection.LEFT,
            modifier = Modifier.weight(1f)
        )
        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = rarity.colorContainer,
            contentColor = rarity.onColorContainer
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
            matchSurfaceColour = rarity.color,
            matchOnSurfaceColor = rarity.onColor,
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
        UpgradeTier(tier = 2, upgradeSelection = UpgradeSelection.RIGHT)
    }
}