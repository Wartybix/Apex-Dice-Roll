package com.example.apexdiceroll.ui

import android.app.Application
import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.AndroidViewModel
import com.example.apexdiceroll.R
import com.example.apexdiceroll.data.GameMode
import com.example.apexdiceroll.data.GameModeCategory
import com.example.apexdiceroll.data.LTMLoadout
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

    private fun getAllGameModes(): List<GameMode> {
        val context = getApplication<Application>().applicationContext

        return listOf(
            GameMode(
                modeName = context.getString(R.string.battle_royale),
                shortName = context.getString(R.string.br),
                category = GameModeCategory.BR,
                teamSize = 4
            ),
            GameMode(
                modeName = context.getString(R.string.mixtape),
                category = GameModeCategory.MIXTAPE,
                teamSize = 3
            )
        )
    }

    private fun getAllLegends(): List<Legend> {
        val context = getApplication<Application>().applicationContext

        return listOf(
            Legend(
                name = context.getString(R.string.bloodhound),
                icon = R.drawable.bloodhound,
                legendClass = LegendClass.Recon
            ),
            Legend(
                name = context.getString(R.string.gibraltar),
                icon = R.drawable.gibraltar,
                legendClass = LegendClass.Support
            ),
            Legend(
                name = context.getString(R.string.lifeline),
                icon = R.drawable.lifeline,
                legendClass = LegendClass.Support
            ),
            Legend(
                name = context.getString(R.string.pathfinder),
                icon = R.drawable.pathfinder,
                legendClass = LegendClass.Skirmisher
            ),
            Legend(
                name = context.getString(R.string.wraith),
                icon = R.drawable.wraith,
                legendClass = LegendClass.Skirmisher
            ),
            Legend(
                name = context.getString(R.string.bangalore),
                icon = R.drawable.bangalore,
                legendClass = LegendClass.Assault
            ),
            Legend(
                name = context.getString(R.string.caustic),
                icon = R.drawable.caustic,
                legendClass = LegendClass.Controller
            ),
            Legend(
                name = context.getString(R.string.mirage),
                icon = R.drawable.mirage,
                legendClass = LegendClass.Support
            ),
            Legend(
                name = context.getString(R.string.octane),
                icon = R.drawable.octane,
                legendClass = LegendClass.Skirmisher
            ),
            Legend(
                name = context.getString(R.string.wattson),
                icon = R.drawable.wattson,
                legendClass = LegendClass.Controller
            ),
            Legend(
                name = context.getString(R.string.crypto),
                icon = R.drawable.crypto,
                legendClass = LegendClass.Recon
            ),
            Legend(
                name = context.getString(R.string.revenant),
                icon = R.drawable.revenant,
                legendClass = LegendClass.Skirmisher
            ),
            Legend(
                name = context.getString(R.string.loba),
                icon = R.drawable.loba,
                legendClass = LegendClass.Support
            ),
            Legend(
                name = context.getString(R.string.rampart),
                icon = R.drawable.rampart,
                legendClass = LegendClass.Controller
            ),
            Legend(
                name = context.getString(R.string.horizon),
                icon = R.drawable.horizon,
                legendClass = LegendClass.Skirmisher
            ),
            Legend(
                name = context.getString(R.string.fuse),
                icon = R.drawable.fuse,
                legendClass = LegendClass.Assault
            ),
            Legend(
                name = context.getString(R.string.valkyrie),
                icon = R.drawable.valk,
                legendClass = LegendClass.Skirmisher
            ),
            Legend(
                name = context.getString(R.string.seer),
                icon = R.drawable.seer,
                legendClass = LegendClass.Recon
            ),
            Legend(
                name = context.getString(R.string.ash),
                icon = R.drawable.ash,
                legendClass = LegendClass.Assault
            ),
            Legend(
                name = context.getString(R.string.mad_maggie),
                icon = R.drawable.mad_maggie,
                legendClass = LegendClass.Assault
            ),
            Legend(
                name = context.getString(R.string.newcastle),
                icon = R.drawable.newcastle,
                legendClass = LegendClass.Support
            ),
            Legend(
                name = context.getString(R.string.vantage),
                icon = R.drawable.vantage,
                legendClass = LegendClass.Recon
            ),
            Legend(
                name = context.getString(R.string.catalyst),
                icon = R.drawable.catalyst,
                legendClass = LegendClass.Controller
            ),
            Legend(
                name = context.getString(R.string.ballistic),
                icon = R.drawable.ballistic,
                legendClass = LegendClass.Assault
            ),
            Legend(
                name = context.getString(R.string.conduit),
                icon = R.drawable.conduit,
                legendClass = LegendClass.Support
            ),
            Legend(
                name = context.getString(R.string.alter),
                icon = R.drawable.alter,
                legendClass = LegendClass.Skirmisher
            )
        )
    }

    private fun randomiseLegendLoadout(teamSize: Int) : List<Legend> {
        val legendLoadout = mutableListOf<Legend>()

        for (priority in 0..<teamSize) {
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

    private fun randomiseLTMLoadout() : LTMLoadout {
        return LTMLoadout.entries.random()
    }

    private fun randomiseLegendUpgrades() : List<UpgradeSelection> {
        val legendUpgrades = mutableListOf<UpgradeSelection>()

        for (rarity in (2..3)) {
            legendUpgrades.add(UpgradeSelection.entries.random())
        }

        return legendUpgrades.toList()
    }

    private fun randomiseGameMode() : Int {
        val generatedCategory = GameModeCategory.entries.random()
        val gameModePool = gameModes.indices.filter { gameModes[it].category == generatedCategory }

        return gameModePool.random()
    }

    private fun fetchLegendLoadout() {
        val selectedGameMode = gameModes[uiState.value.selectedGameModeIndex]
        uiState.value.generatedLegends = randomiseLegendLoadout(selectedGameMode.teamSize) //TODO add IO
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

        val selectedGameMode = gameModes[uiState.value.selectedGameModeIndex]

        if (selectedGameMode.category == GameModeCategory.BR) {
            val upgradesSerialised = uiState.value.legendUpgrades.map { upgradeSelection ->
                upgradeSelection.ordinal.toByte()
            }.toByteArray()

            saveToDisk(LEGEND_UPGRADES_FILE) { stream -> stream.write(upgradesSerialised) }
        } else if (selectedGameMode.category == GameModeCategory.MIXTAPE) {
            val mixtapeLoadoutSerialised = uiState.value.mixtapeLoadout.ordinal

            saveToDisk(MIXTAPE_FILE) { stream -> stream.write(mixtapeLoadoutSerialised) }
        }
    }

    private fun saveGameMode() {
        val gameModeSerialised = uiState.value.selectedGameModeIndex

        saveToDisk(GAME_MODE_FILE) { stream -> stream.write(gameModeSerialised) }
    }

    private fun saveSelections() {
        val selectionsSerialised = legendRoster.indices.filter { legendIndex ->
            legendRoster[legendIndex].selected
        }.map {
            it.toByte()
        }.toByteArray()

        saveToDisk(SELECTIONS_FILE) { stream -> stream.write(selectionsSerialised) }
    }

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    private val _legendRoster: SnapshotStateList<Legend> = getAllLegends().toMutableStateList()
    val legendRoster: List<Legend>
        get() = _legendRoster
    private val _gameModes: SnapshotStateList<GameMode> = getAllGameModes().toMutableStateList()
    val gameModes: List<GameMode>
        get() = _gameModes

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

    fun switchGameMode(requestedGameMode: Int?) {
        val newGameMode = requestedGameMode ?: randomiseGameMode()
        val isRandomised = requestedGameMode == null

        _uiState.update { currentState ->
            currentState.copy(
                selectedGameModeIndex = newGameMode,
                gameModeRandomised = isRandomised
            )
        }
    }

    fun rollDice() {
        val currentGameModeIndex = uiState.value.selectedGameModeIndex

        val newGameModeIndex = if (uiState.value.gameModeRandomised)
            randomiseGameMode()
        else
            currentGameModeIndex

        val newGameMode = gameModes[newGameModeIndex]

        val generatedLegends = randomiseLegendLoadout(teamSize = newGameMode.teamSize)

        val mixtapeLoadout = if (
            newGameMode.category == GameModeCategory.MIXTAPE
        ) {
            randomiseMixtapeLoadout()
        } else {
            uiState.value.mixtapeLoadout
        }

        val ltmLoadout = if (
            newGameMode.category == GameModeCategory.MIXTAPE
        ) {
            randomiseLTMLoadout()
        } else {
            uiState.value.ltmLoadout
        }

        val legendUpgrades = if (
            newGameMode.category == GameModeCategory.BR
        ) {
            randomiseLegendUpgrades()
        }
        else {
            uiState.value.legendUpgrades
        }

        _uiState.update { currentState ->
            currentState.copy(
                selectedGameModeIndex = newGameModeIndex,
                generatedLegends = generatedLegends,
                mixtapeLoadout = mixtapeLoadout,
                ltmLoadout = ltmLoadout,
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