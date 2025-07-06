package com.minimalistcraft.android.dailydrive.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.components.ChipGroup
import com.minimalistcraft.android.core.components.HabitItem
import com.minimalistcraft.android.core.components.Header
import com.minimalistcraft.android.core.components.RepeatTypeTab
import com.minimalistcraft.android.core.components.SwipeableHabitItem
import com.minimalistcraft.android.core.components.TextDivider
import com.minimalistcraft.android.dailydrive.R
import com.minimalistcraft.android.dailydrive.model.HabitUiModel
import com.minimalistcraft.android.dailydrive.model.RepeatTypeUiModel
import com.minimalistcraft.android.dailydrive.model.TimeOfDayUiModel
import com.minimalistcraft.android.dailydrive.utils.active
import com.minimalistcraft.android.dailydrive.utils.completed
import com.minimalistcraft.android.dailydrive.utils.displayName
import com.minimalistcraft.android.dailydrive.utils.toRepeatType

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState is HomeUiState.Success) {
        val habits = (uiState as HomeUiState.Success).habits
        HomeContent(
            modifier = modifier,
            habits = habits
        )
    }

}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    habits: List<HabitUiModel>
) {

    val repeatTypeList = RepeatTypeUiModel.getRepeatTypeList().map {
        it.displayName(LocalContext.current)
    }

    val timeOfDay = TimeOfDayUiModel.getTimeOfDayList().map {
        it.displayName(LocalContext.current)
    }

    var selectedChip by remember { mutableStateOf(timeOfDay.first()) }

    Column(modifier = modifier.fillMaxSize()) {
        Header(title = stringResource(R.string.home))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            RepeatTypeTab(
                items = repeatTypeList,
                onTabSelected = {
                    Log.d(TAG, "onTabSelected: ${it.toRepeatType()}")
                }
            )
            ChipGroup(
                chips = timeOfDay,
                selectedLabel = selectedChip,
                onChipSelected = {
                    selectedChip = it
                })
            HabitList(habits = habits)
        }
    }

}

@Composable
fun HabitList(habits: List<HabitUiModel>) {
    val activeHabits = habits.active()
    val completedHabits = habits.completed()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(activeHabits, key = { it.id }) {
            SwipeableHabitItem(
                id = it.id,
                name = it.name,
                isCompleted = it.isCompleted,
                onSwipeCompleted = {
                    Log.d(TAG, "onSwipeCompleted: with id = $it")
                }
            )
        }
        if (completedHabits.isNotEmpty() && activeHabits.isNotEmpty()) {
            item {
                TextDivider(text = stringResource(R.string.completed))
            }
        }
        items(completedHabits, key = { it.id }) {
            HabitItem(
                name = it.name,
                isCompleted = it.isCompleted
            )
        }
    }
}

@CustomPreview
@Composable
private fun HomeScrPreview() {
    ThemedPreview {
        HomeContent(
            habits = listOf(
                HabitUiModel(
                    id = 1,
                    name = "Daily Habit 1",
                ),
                HabitUiModel(
                    id = 3,
                    name = "Daily Habit 1",
                ),
                HabitUiModel(
                    id = 2,
                    name = "Daily Habit 2",
                    isCompleted = true
                ),
                HabitUiModel(
                    id = 4,
                    name = "Daily Habit 2",
                    isCompleted = true
                )
            )
        )
    }
}