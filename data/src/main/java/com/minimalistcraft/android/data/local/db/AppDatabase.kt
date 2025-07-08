package com.minimalistcraft.android.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.minimalistcraft.android.data.local.dao.HabitDao
import com.minimalistcraft.android.data.local.db.converters.DateTimeConverters
import com.minimalistcraft.android.data.local.db.converters.EnumConverters
import com.minimalistcraft.android.data.local.model.HabitCheckInEntity
import com.minimalistcraft.android.data.local.model.HabitDailyRuleEntity
import com.minimalistcraft.android.data.local.model.HabitEntity
import com.minimalistcraft.android.data.local.model.HabitMonthlyRuleEntity
import com.minimalistcraft.android.data.local.model.HabitWeeklyRuleEntity
import com.minimalistcraft.android.data.local.model.OneTimeTaskEntity

@Database(
    entities = [HabitEntity::class,
        HabitDailyRuleEntity::class,
        HabitWeeklyRuleEntity::class,
        HabitMonthlyRuleEntity::class,
        HabitCheckInEntity::class,
        OneTimeTaskEntity::class
    ],
    version = 1
)
@TypeConverters(EnumConverters::class, DateTimeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}