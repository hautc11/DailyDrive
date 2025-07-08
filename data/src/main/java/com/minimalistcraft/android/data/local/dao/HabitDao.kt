package com.minimalistcraft.android.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.minimalistcraft.android.data.local.model.HabitEntity

@Dao
interface HabitDao {
    @Query("SELECT * FROM habits")
    fun getAllHabits(): List<HabitEntity>
}