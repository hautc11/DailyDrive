package com.minimalistcraft.android.core.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Habit(
    val id: Int,
    val name: String,
    @DrawableRes val iconRes: Int? = null,
    @ColorRes val backgroundColor: Int? = null,
    val isCompleted: Boolean = false
)
