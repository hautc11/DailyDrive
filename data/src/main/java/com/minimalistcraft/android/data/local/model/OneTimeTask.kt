package com.minimalistcraft.android.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "one_time_task")
data class OneTimeTaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "due_date") val dueDate: Instant,
    @ColumnInfo(name = "reminder") val reminder: Instant?,
    @ColumnInfo(name = "is_complete") val isComplete: Boolean
)
