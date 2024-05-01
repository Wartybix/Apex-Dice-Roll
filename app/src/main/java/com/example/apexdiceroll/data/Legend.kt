package com.example.apexdiceroll.data

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Legend(
    val name: String,
    @DrawableRes val icon: Int,
    var legendClass: LegendClass,
) {
    var selected by mutableStateOf(true)
    var wins by mutableIntStateOf(0)
}
