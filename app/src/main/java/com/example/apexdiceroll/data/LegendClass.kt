package com.example.apexdiceroll.data

import androidx.annotation.DrawableRes
import com.example.apexdiceroll.R

enum class LegendClass(val className: String, @DrawableRes val icon: Int) {
    Assault(className = "Assault", icon = R.drawable.class_assault),
    Controller(className = "Controller", icon = R.drawable.class_controller),
    Recon(className = "Recon", icon = R.drawable.class_recon),
    Skirmisher(className = "Skirmisher", icon = R.drawable.class_skirmisher),
    Support(className = "Support", icon = R.drawable.class_support),
}