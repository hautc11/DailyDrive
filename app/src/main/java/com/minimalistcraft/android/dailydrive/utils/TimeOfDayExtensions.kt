package com.minimalistcraft.android.dailydrive.utils

import android.content.Context
import com.minimalistcraft.android.dailydrive.R
import com.minimalistcraft.android.domain.model.TimeOfDay

fun TimeOfDay.displayName(context: Context): String = when (this) {
    TimeOfDay.ALL -> context.getString(R.string.tod_all)
    TimeOfDay.MORNING -> context.getString(R.string.tod_morning)
    TimeOfDay.AFTERNOON -> context.getString(R.string.tod_afternoon)
    TimeOfDay.EVENING -> context.getString(R.string.tod_evening)
}