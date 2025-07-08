package com.minimalistcraft.android.domain.repository

import com.minimalistcraft.android.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface IHabitRepository {
    fun getAllHabits(): Flow<List<Habit>>
}