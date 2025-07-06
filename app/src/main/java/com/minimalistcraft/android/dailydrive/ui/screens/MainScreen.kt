package com.minimalistcraft.android.dailydrive.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.MainTextColorDark
import com.minimalistcraft.android.core.design.TabActiveColor
import com.minimalistcraft.android.dailydrive.R
import com.minimalistcraft.android.dailydrive.ui.navigation.AppNavigationGraph
import com.minimalistcraft.android.dailydrive.ui.navigation.BottomNavItem
import com.minimalistcraft.android.dailydrive.ui.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
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
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = TabActiveColor,
                contentColor = MainTextColorDark
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_plus),
                    contentDescription = "",
                )
            }
        },
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