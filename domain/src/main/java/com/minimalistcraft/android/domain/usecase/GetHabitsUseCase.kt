package com.minimalistcraft.android.domain.usecase

import com.minimalistcraft.android.domain.model.Habit
import com.minimalistcraft.android.domain.repository.IHabitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHabitsUseCase @Inject constructor(
    private val habitRepository: IHabitRepository
) {
    fun execute(): Flow<List<Habit>> {
        return habitRepository.getAllHabits()
    }
}