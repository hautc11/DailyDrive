package com.minimalistcraft.android.dailydrive.utils

import android.content.Context
import com.minimalistcraft.android.dailydrive.R
import com.minimalistcraft.android.domain.model.RepeatType

fun RepeatType.displayName(context: Context): String = when (this) {
    RepeatType.DAILY -> context.getString(R.string.repeat_daily)
    RepeatType.WEEKLY -> context.getString(R.string.repeat_weekly)
    RepeatType.MONTHLY -> context.getString(R.string.repeat_monthly)
}

fun String.toRepeatType(): RepeatType = when (this) {
    "Daily" -> RepeatType.DAILY
    "Weekly" -> RepeatType.WEEKLY
    "Monthly" -> RepeatType.MONTHLY
    else -> throw IllegalArgumentException("Invalid repeat type: $this")

}