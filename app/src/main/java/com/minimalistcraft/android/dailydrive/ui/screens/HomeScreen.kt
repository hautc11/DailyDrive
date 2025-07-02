package com.minimalistcraft.android.dailydrive.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.AppTheme.typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row {
            Text(
                text = "typography.titleBold",
                color = colors.mainTextColor,
                style = typography.titleBold
            )
        }
        Row {
            Text(
                text = "typography.titleMedium",
                color = colors.mainTextColor,
                style = typography.titleMedium
            )
        }
        Row {
            Text(
                text = "typography.labelRegular",
                color = colors.mainTextColor,
                style = typography.labelRegular
            )
        }
        Row {
            Text(
                text = "typography.bodySmall",
                color = colors.mainTextColor,
                style = typography.bodyMedium
            )
        }
    }
}