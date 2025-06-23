package com.minimalistcraft.android.core.design

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RippleConfiguration
import androidx.compose.ui.graphics.Color

object AppRipple {
    @OptIn(ExperimentalMaterial3Api::class)
    val default = RippleConfiguration(
        color = Color.Transparent,
        rippleAlpha = RippleAlpha(
            pressedAlpha = 0f,
            focusedAlpha = 0f,
            draggedAlpha = 0f,
            hoveredAlpha = 0f
        )
    )
}