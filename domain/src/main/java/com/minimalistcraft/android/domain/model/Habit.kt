package com.minimalistcraft.android.domain.model

data class Habit(
    val id: Int,
    val name: String,
    val iconRes: Int? = null,
    val backgroundColor: Int? = null,
    val isCompleted: Boolean = false
)
