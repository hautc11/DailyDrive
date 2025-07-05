package com.minimalistcraft.android.dailydrive.ui.screens.home

import com.minimalistcraft.android.dailydrive.model.HabitUiModel

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Success(val habits: List<HabitUiModel>): HomeUiState()
}