package com.minimalistcraft.android.data.local.db.converters

import androidx.room.TypeConverter
import com.minimalistcraft.android.data.local.model.DayOfWeek
import com.minimalistcraft.android.data.local.model.TimeOfDay

class EnumConverters {
    @TypeConverter
    fun fromDayOfWeek(value: DayOfWeek): String = value.name

    @TypeConverter
    fun toDayOfWeek(value: String): DayOfWeek = DayOfWeek.valueOf(value)

    @TypeConverter
    fun fromTimeOfDay(value: TimeOfDay): String = value.name

    @TypeConverter
    fun toTimeOfDay(value: String): TimeOfDay = TimeOfDay.valueOf(value)

}