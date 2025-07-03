package com.minimalistcraft.android.core.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyDriveTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalRippleConfiguration provides AppRipple.default
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object AppTheme {
    val colors: BaseColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current
}