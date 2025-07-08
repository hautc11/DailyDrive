package com.minimalistcraft.android.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "habit_daily_rule",
    foreignKeys = [
        ForeignKey(
            entity = HabitEntity::class,
            parentColumns = ["id"],
            childColumns = ["habit_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class HabitDailyRuleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "habit_id") val habitId: Int?,
    @ColumnInfo(name = "day_of_week") val dayOfWeek: DayOfWeek?,
    @ColumnInfo(name = "time_of_day") val timeOfDay: TimeOfDay?
)