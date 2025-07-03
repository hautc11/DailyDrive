package com.minimalistcraft.android.dailydrive.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.BodyTiny

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    items: List<BottomNavItem>
) {
    NavigationBar(
        modifier = modifier,
        containerColor = colors.mainBackground
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = if (currentRoute == item.route) {
                            painterResource(id = item.iconSelected)
                        } else {
                            painterResource(id = item.icon)
                        },
                        tint = Color.Unspecified,
                        contentDescription = stringResource(id = item.label)
                    )
                },
                label = {
                    Text(
                        stringResource(item.label), color = if (currentRoute == item.route) {
                            colors.indicatorTextColor
                        } else {
                            colors.mainTextColor
                        },
                        style = BodyTiny
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}