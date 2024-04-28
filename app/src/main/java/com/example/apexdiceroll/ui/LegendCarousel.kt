package com.example.apexdiceroll.ui

import android.renderscript.Long3
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import androidx.compose.foundation.lazy.items

@Composable
fun LegendCarousel(
    legendLoadout: List<Legend>
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
    ) {
        items(legendLoadout.indices.toList()) { item ->
            val legend = legendLoadout[item]

            LegendCard(
                priorityNo = item + 1,
                legendName = legend.name,
                classIcon = legend.legendClass.icon,
                legendIcon = legend.icon,
            )
        }
    }
}

@Preview
@Composable
fun LegendCarouselPreview() {
    LegendCarousel(legendLoadout = listOf(
        Legend("Gibraltar", R.drawable.gibraltar, LegendClass.Support),
        Legend("Revenant", R.drawable.revenant, LegendClass.Assault),
        Legend("Conduit", R.drawable.conduit, LegendClass.Support),
    ))
}