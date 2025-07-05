package com.minimalistcraft.android.dailydrive.utils

import com.minimalistcraft.android.dailydrive.model.HabitUiModel

fun List<HabitUiModel>.completed(): List<HabitUiModel> = filter { it.isCompleted }
fun List<HabitUiModel>.active(): List<HabitUiModel> = filterNot { it.isCompleted }