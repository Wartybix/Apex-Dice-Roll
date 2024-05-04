package com.example.apexdiceroll.ui.components.diceroll_screen.upgrades_area

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.data.UpgradeSelection

@Composable
fun UpgradesDisplay(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        (2..3).forEach {
            if (it != 2) {
                Spacer(modifier = Modifier.size(8.dp))
            }
            UpgradeTier(tier = it, upgradeSelection = UpgradeSelection.LEFT)
        }
    }

}

@Preview
@Composable
fun UpgradesDisplayPreview() {
    Surface {
        UpgradesDisplay()
    }

}