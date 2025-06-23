package com.minimalistcraft.android.core.design

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class BaseColorScheme(
    val mainBackground: Color = Color.Unspecified,
    val mainTextColor: Color = Color.Unspecified,
    val indicatorTextColor: Color = Color.Unspecified,
)

val DarkColorScheme = BaseColorScheme(
    mainBackground = MainBackGroundDark,
    mainTextColor = MainTextColorDark,
    indicatorTextColor = IndicatorTextColorDark
)

val LightColorScheme = BaseColorScheme(
    mainBackground = MainBackGroundLight,
    mainTextColor = MainTextColorLight,
    indicatorTextColor = IndicatorTextColorLight
)

val LocalColorScheme = staticCompositionLocalOf { LightColorScheme }
