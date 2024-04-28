package com.example.apexdiceroll.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(UiState())

    private fun getLegendRoster(): List<Legend> {
        return listOf(
            Legend("Bloodhound", R.drawable.bloodhound, LegendClass.Recon),
            Legend("Gibraltar", R.drawable.gibraltar, LegendClass.Support),
            Legend("Lifeline", R.drawable.lifeline, LegendClass.Support),
            Legend("Pathfinder", R.drawable.pathfinder, LegendClass.Skirmisher),
            Legend("Wraith", R.drawable.wraith, LegendClass.Skirmisher),
            Legend("Bangalore", R.drawable.bangalore, LegendClass.Assault),
            Legend("Caustic", R.drawable.caustic, LegendClass.Controller),
            Legend("Mirage", R.drawable.mirage, LegendClass.Support),
            Legend("Octane", R.drawable.octane, LegendClass.Skirmisher),
            Legend("Wattson", R.drawable.wattson, LegendClass.Controller),
            Legend("Crypto", R.drawable.crypto, LegendClass.Recon),
            Legend("Revenant", R.drawable.revenant, LegendClass.Skirmisher),
            Legend("Loba", R.drawable.loba, LegendClass.Support),
            Legend("Rampart", R.drawable.rampart, LegendClass.Controller),
            Legend("Horizon", R.drawable.horizon, LegendClass.Skirmisher),
            Legend("Fuse", R.drawable.fuse, LegendClass.Assault),
            Legend("Valkyrie", R.drawable.valk, LegendClass.Skirmisher),
            Legend("Seer", R.drawable.seer, LegendClass.Recon),
            Legend("Ash", R.drawable.ash, LegendClass.Assault),
            Legend("Mad Maggie", R.drawable.mad_maggie, LegendClass.Assault),
            Legend("Newcastle", R.drawable.newcastle, LegendClass.Support),
            Legend("Vantage", R.drawable.vantage, LegendClass.Recon),
            Legend("Catalyst", R.drawable.catalyst, LegendClass.Controller),
            Legend("Ballistic", R.drawable.ballistic, LegendClass.Assault),
            Legend("Conduit", R.drawable.conduit, LegendClass.Support)
        )
    }

    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    val legendRoster: List<Legend> = getLegendRoster()
}