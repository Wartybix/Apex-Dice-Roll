package com.example.apexdiceroll.data

import androidx.annotation.DrawableRes
import com.example.apexdiceroll.R

enum class LegendClass(val className: String, @DrawableRes val icon: Int) {
    Assault(className = "Assault", icon = R.drawable.class_assault),
    Skirmisher(className = "Skirmisher", icon = R.drawable.class_skirmisher),
    Recon(className = "Recon", icon = R.drawable.class_recon),
    Support(className = "Support", icon = R.drawable.class_support),
    Controller(className = "Controller", icon = R.drawable.class_controller),
}