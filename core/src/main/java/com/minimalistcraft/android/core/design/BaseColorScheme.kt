package com.minimalistcraft.android.core.design

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class BaseColorScheme(
    val mainBackground: Color = Color.Unspecified,
    val mainTextColor: Color = Color.Unspecified,
    val secondaryTextColor: Color = Color.Unspecified,
    val indicatorTextColor: Color = Color.Unspecified,
    val tabBackground: Color = Color.Unspecified,
    val strokeBorder: Color = Color.Unspecified
)

val DarkColorScheme = BaseColorScheme(
    mainBackground = MainBackGroundDark,
    mainTextColor = MainTextColorDark,
    secondaryTextColor = SecondaryTextColorDark,
    indicatorTextColor = IndicatorTextColorDark,
    tabBackground = TabBackgroundDark,
    strokeBorder = StrokeBorderDark
)

val LightColorScheme = BaseColorScheme(
    mainBackground = MainBackGroundLight,
    mainTextColor = MainTextColorLight,
    secondaryTextColor = SecondaryTextColorLight,
    indicatorTextColor = IndicatorTextColorLight,
    tabBackground = TabBackgroundLight,
    strokeBorder = StrokeBorderLight
)

val LocalColorScheme = staticCompositionLocalOf { LightColorScheme }
