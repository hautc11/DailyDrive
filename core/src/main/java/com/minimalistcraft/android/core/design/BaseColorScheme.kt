package com.minimalistcraft.android.core.design

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class BaseColorScheme(
    val mainBackground: Color
)

val DarkColorScheme = BaseColorScheme(
    mainBackground = MainBackGroundDark
)

val LightColorScheme = BaseColorScheme(
    mainBackground = MainBackGroundLight
)

val LocalColorScheme = staticCompositionLocalOf { LightColorScheme }
