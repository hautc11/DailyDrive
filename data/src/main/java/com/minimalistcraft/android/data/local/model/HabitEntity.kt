package com.minimalistcraft.android.data.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.Instant

@Entity(tableName = "habits")
@Parcelize
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "ic_res") val icRes: Int?,
    @ColumnInfo(name = "color_res") val colorRes: Int?,
    @ColumnInfo(name = "repeat_type") val repeatType: String?,
    @ColumnInfo(name = "end_date") val endDate: Instant?,
    @ColumnInfo(name = "reminder_time") val reminderTime: Instant?,
) : Parcelable