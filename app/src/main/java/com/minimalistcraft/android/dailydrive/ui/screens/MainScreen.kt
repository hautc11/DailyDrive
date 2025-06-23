package com.minimalistcraft.android.dailydrive.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.LocalColorScheme
import com.minimalistcraft.android.dailydrive.ui.components.BottomNavigationBar
import com.minimalistcraft.android.dailydrive.ui.navigation.AppNavigationGraph
import com.minimalistcraft.android.dailydrive.ui.navigation.BottomNavItem

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = BottomNavItem.items
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.mainBackground)
                .padding(innerPadding)
        ) {
            AppNavigationGraph(navController = navController)
        }
    }
}