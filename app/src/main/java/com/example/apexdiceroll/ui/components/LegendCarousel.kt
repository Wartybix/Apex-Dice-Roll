package com.example.apexdiceroll.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass

@Composable
fun LegendCarousel(
    legendLoadout: List<Legend>,
) {
    val carouselState = rememberLazyListState()
    
    LaunchedEffect(legendLoadout) {
        carouselState.animateScrollToItem(0)
    }
    
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
        state = carouselState
    ) {
        itemsIndexed(legendLoadout) { index, legend ->
            LegendCard(
                priorityNo = index + 1,
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