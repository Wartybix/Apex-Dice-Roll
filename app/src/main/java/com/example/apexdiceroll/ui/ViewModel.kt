package com.example.apexdiceroll.ui

import android.app.Application
import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.AndroidViewModel
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.GameMode
import com.example.apexdiceroll.data.Legend
import com.example.apexdiceroll.data.LegendClass
import com.example.apexdiceroll.data.LegendsSelected
import com.example.apexdiceroll.data.MixtapeLoadout
import com.example.apexdiceroll.data.Screen
import com.example.apexdiceroll.data.UiState
import com.example.apexdiceroll.data.UpgradeSelection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.FileOutputStream

class ViewModel(application: Application) : AndroidViewModel(application) {
    companion object {
        private const val EXTENSION = ".txt"

        const val GAME_MODE_FILE = "game_mode$EXTENSION"
        const val GENERATED_LEGENDS_FILE = "generated_legends$EXTENSION"
        const val MIXTAPE_FILE = "mixtape$EXTENSION"
        const val LEGEND_UPGRADES_FILE = "upgrades$EXTENSION"
        const val WINS_FILE = "wins$EXTENSION"
        const val SELECTIONS_FILE = "selections$EXTENSION"
    }
    private fun getAllLegends(): List<Legend> {
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
            Legend("Conduit", R.drawable.conduit, LegendClass.Support),
            Legend("Alter", R.drawable.alter, LegendClass.Skirmisher)
        )
    }

    private fun randomiseLegendLoadout() : List<Legend> {
        val legendLoadout = mutableListOf<Legend>()

        for (priority in 0..2) {
            val availableLegends = legendRoster.filterNot { it in legendLoadout }
            val availableSelectedLegends = availableLegends.filter { it.selected }

            val legendPool = if (availableSelectedLegends.any()) {
                availableSelectedLegends
            }
            else {
                availableLegends
            }

            val generatedLegend = legendPool.random()
            legendLoadout.add(generatedLegend)
        }

        return legendLoadout.toList()
    }

    private fun randomiseMixtapeLoadout() : MixtapeLoadout {
        return MixtapeLoadout.entries.random()
    }

    private fun randomiseLegendUpgrades() : List<UpgradeSelection> {
        val legendUpgrades = mutableListOf<UpgradeSelection>()

        for (rarity in (2..3)) {
            legendUpgrades.add(UpgradeSelection.entries.random())
        }

        return legendUpgrades.toList()
    }

    private fun fetchLegendLoadout() {
        uiState.value.generatedLegends = randomiseLegendLoadout() //TODO add IO
    }

    private fun fetchMixtapeLoadout() {
        uiState.value.mixtapeLoadout = randomiseMixtapeLoadout() //TODO add IO
    }

    private fun fetchLegendUpgrades() {
        uiState.value.legendUpgrades = randomiseLegendUpgrades() //TODO add IO
    }

    private fun saveToDisk(filename: String, writeFunction: (FileOutputStream) -> Unit) {
        val context = getApplication<Application>().applicationContext

        context.openFileOutput(filename, Context.MODE_PRIVATE).use {
            writeFunction(it)
        }
    }

    private fun saveDiceRoll() {
        /*
         Convert generated legends into a list of their respective indices in the legend roster.
         Each index is converted to a byte.
         Then, the whole list is converted to a ByteArray.
         */
        val legendsSerialised = uiState.value.generatedLegends.map { legend ->
            legendRoster.indexOf(legend).toByte()
        }.toByteArray()

        saveToDisk(GENERATED_LEGENDS_FILE) { stream -> stream.write(legendsSerialised) }

        if (uiState.value.selectedGameMode == GameMode.BR) {
            val upgradesSerialised = uiState.value.legendUpgrades.map { upgradeSelection ->
                upgradeSelection.ordinal.toByte()
            }.toByteArray()

            saveToDisk(LEGEND_UPGRADES_FILE) { stream -> stream.write(upgradesSerialised) }
        } else if (uiState.value.selectedGameMode == GameMode.Mixtape) {
            val mixtapeLoadoutSerialised = uiState.value.mixtapeLoadout.ordinal

            saveToDisk(MIXTAPE_FILE) { stream -> stream.write(mixtapeLoadoutSerialised) }
        }
    }

    private fun saveGameMode() {
        val gameModeSerialised = uiState.value.selectedGameMode.ordinal

        saveToDisk(GAME_MODE_FILE) { stream -> stream.write(gameModeSerialised) }
    }

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    private val _legendRoster: SnapshotStateList<Legend> = getAllLegends().toMutableStateList()
    val legendRoster: List<Legend>
        get() = _legendRoster

    init {
        fetchLegendLoadout()
        fetchLegendUpgrades()
        fetchMixtapeLoadout()
        //TODO do only one of the two lines above depending on selected game mode.
    }

    fun switchScreen(newScreen: Screen) {
        _uiState.update { currentState ->
            currentState.copy(
                currentScreen = newScreen
            )
        }
    }

    fun switchGameMode(newGameMode: GameMode) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedGameMode = newGameMode
            )
        }
    }

    fun rollDice() {
        val generatedLegends = randomiseLegendLoadout()
        val mixtapeLoadout = randomiseMixtapeLoadout()
        val legendUpgrades = randomiseLegendUpgrades()
        //TODO ensure only processing for selected game mode is done.

        _uiState.update { currentState ->
            currentState.copy(
                generatedLegends = generatedLegends,
                mixtapeLoadout = mixtapeLoadout,
                legendUpgrades = legendUpgrades
            )
        }
    }

    fun rosterToggleAll(value: Boolean) {
        legendRoster.forEach { it.selected = value }
    }

    fun getRosterSelectionStatus() : LegendsSelected {
        return if (legendRoster.all { it.selected } ) {
            LegendsSelected.ALL
        } else if (legendRoster.any { it.selected }) {
            LegendsSelected.SOME
        } else {
            LegendsSelected.NONE
        }
    }
}