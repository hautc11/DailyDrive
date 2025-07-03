package com.minimalistcraft.android.core.annotation

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.minimalistcraft.android.core.design.DailyDriveTheme

@Preview(
    name = "Night Mode",
    showBackground = true,
    device = "id:pixel_8",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    backgroundColor = 0xFF181A20
)
@Preview(
    name = "Day Mode",
    showBackground = true,
    device = "id:pixel_8",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    backgroundColor = 0xFFFFFFFF
)
annotation class CustomPreview


@Composable
fun ThemedPreview(content: @Composable () -> Unit) {
    DailyDriveTheme {
        content()
    }
}