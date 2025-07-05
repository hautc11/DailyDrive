package com.minimalistcraft.android.dailydrive.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.components.ChipGroup
import com.minimalistcraft.android.core.components.DailyHabit
import com.minimalistcraft.android.core.components.Header
import com.minimalistcraft.android.core.components.RepeatTypeTab
import com.minimalistcraft.android.core.components.TextDivider
import com.minimalistcraft.android.dailydrive.R
import com.minimalistcraft.android.dailydrive.model.HabitUiModel
import com.minimalistcraft.android.dailydrive.utils.active
import com.minimalistcraft.android.dailydrive.utils.completed

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
    Column(modifier = modifier.fillMaxSize()) {
        Header(title = stringResource(R.string.home))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            RepeatTypeTab(
                items = listOf("Daily", "Weekly", "Monthly")
            )
            ChipGroup(chips = listOf("All", "Morning", "Afternoon", "Evening"))
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
            DailyHabit(
                icon = painterResource(com.minimalistcraft.android.core.R.drawable.ic_completed),
                name = it.name,
                isCompleted = it.isCompleted
            )
        }
        if (completedHabits.isNotEmpty() && activeHabits.isNotEmpty()) {
            item {
                TextDivider(text = stringResource(R.string.completed))
            }
        }
        items(completedHabits, key = { it.id }) {
            DailyHabit(
                icon = painterResource(com.minimalistcraft.android.core.R.drawable.ic_completed),
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
                    iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                ),
                HabitUiModel(
                    id = 3,
                    name = "Daily Habit 1",
                    iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                ),
                HabitUiModel(
                    id = 2,
                    name = "Daily Habit 2",
                    iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                    isCompleted = true
                ),
                HabitUiModel(
                    id = 4,
                    name = "Daily Habit 2",
                    iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                    isCompleted = true
                )
            )
        )
    }
}