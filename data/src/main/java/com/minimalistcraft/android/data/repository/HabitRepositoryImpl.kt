package com.minimalistcraft.android.data.repository

import com.minimalistcraft.android.data.local.dao.HabitDao
import com.minimalistcraft.android.domain.model.Habit
import com.minimalistcraft.android.domain.repository.IHabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(
    private val habitDao: HabitDao
): IHabitRepository {

    override fun getAllHabits(): Flow<List<Habit>> {
        return flow {
            emptyList<Habit>()
        }
    }
}