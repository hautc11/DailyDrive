package com.minimalistcraft.android.dailydrive.ui.screens.home

import androidx.lifecycle.ViewModel
import com.minimalistcraft.android.dailydrive.model.HabitUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState>
        get() = _uiState

    init {
        loadDummyData()
    }

    private fun loadDummyData() {
        val dummyList = listOf(
            HabitUiModel(
                id = 1,
                name = "Daily Habit 1",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
            ),
            HabitUiModel(
                id = 2,
                name = "Daily Habit 2",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
            ),
            HabitUiModel(
                id = 3,
                name = "Daily Habit 3",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
            ),
            HabitUiModel(
                id = 4,
                name = "Daily Habit 4",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
            ),
            HabitUiModel(
                id = 5,
                name = "Daily Habit 5",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
            ),
            HabitUiModel(
                id = 6,
                name = "Daily Habit 1",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                isCompleted = true
            ),
            HabitUiModel(
                id = 7,
                name = "Daily Habit 7",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                isCompleted = true
            ),
            HabitUiModel(
                id = 8,
                name = "Daily Habit 8",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                isCompleted = true
            ),
            HabitUiModel(
                id = 9,
                name = "Daily Habit 9",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                isCompleted = true
            ),
            HabitUiModel(
                id = 10,
                name = "Daily Habit 10",
                iconRes = com.minimalistcraft.android.core.R.drawable.ic_completed,
                isCompleted = true
            )
        )
        _uiState.value = HomeUiState.Success(dummyList)

    }
}