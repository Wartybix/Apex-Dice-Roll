package com.example.apexdiceroll.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R

@Composable
fun LegendCard(
    priorityNo: Int,
    legendName: String,
    @DrawableRes classIcon: Int,
    @DrawableRes legendIcon: Int
) {
    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = legendIcon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(text = stringResource(R.string.priority_no, priorityNo),
                style = MaterialTheme.typography.labelMedium)

            Spacer(modifier = Modifier.size(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = ImageVector.vectorResource(classIcon),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = legendName,
                    style = MaterialTheme.typography.titleLarge
                )
            }


            Spacer(modifier = Modifier.size(24.dp))
        }
    }
}

@Preview
@Composable
fun LegendCardPreview() {
    LegendCard(
        priorityNo = 1,
        legendName = "Valkyrie",
        legendIcon = R.drawable.valk,
        classIcon = R.drawable.class_skirmisher
    )
}