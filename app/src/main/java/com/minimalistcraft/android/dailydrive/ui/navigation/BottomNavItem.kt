package com.minimalistcraft.android.dailydrive.ui.navigation

import com.minimalistcraft.android.dailydrive.R

sealed class BottomNavItem(val route: String, val icon: Int, val iconSelected: Int, val label: Int) {
    data object Home : BottomNavItem("home", R.drawable.ic_home, R.drawable.ic_home_selected, R.string.home)
    data object Report : BottomNavItem("report", R.drawable.ic_report, R.drawable.ic_report_selected, R.string.report)
    data object Habit : BottomNavItem("my_habit", R.drawable.ic_habit, R.drawable.ic_habit_selected, R.string.my_habit)
    data object Profile : BottomNavItem("profile", R.drawable.ic_profile, R.drawable.ic_profile_selected, R.string.profile)

    companion object {
        val items = listOf(Home, Report, Habit, Profile)
    }
}