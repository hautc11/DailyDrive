package com.minimalistcraft.android.dailydrive.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.minimalistcraft.android.dailydrive.ui.screens.HabitScreen
import com.minimalistcraft.android.dailydrive.ui.screens.home.HomeScreen
import com.minimalistcraft.android.dailydrive.ui.screens.ProfileScreen
import com.minimalistcraft.android.dailydrive.ui.screens.ReportScreen

@Composable
fun AppNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) { HomeScreen() }
        composable(BottomNavItem.Report.route) { ReportScreen() }
        composable(BottomNavItem.Habit.route) { HabitScreen() }
        composable(BottomNavItem.Profile.route) { ProfileScreen() }
    }
}