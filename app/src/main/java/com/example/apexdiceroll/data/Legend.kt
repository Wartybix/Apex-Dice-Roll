package com.example.apexdiceroll.data

import androidx.annotation.DrawableRes

data class Legend(
    val name: String,
    @DrawableRes val icon: Int,
    var legendClass: LegendClass
)
