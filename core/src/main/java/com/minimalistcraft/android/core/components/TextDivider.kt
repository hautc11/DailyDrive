package com.minimalistcraft.android.core.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.BodyStrong

@Composable
fun TextDivider(modifier: Modifier = Modifier, text: String) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = text,
            color = colors.secondaryTextColor,
            style = BodyStrong
        )
        Spacer(Modifier.width(14.dp))
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 2.dp,
            color = colors.strokeBorder
        )
    }
}

@CustomPreview
@Composable
private fun TextDividerPreview() {
    ThemedPreview {
        TextDivider(text = "Daily Habit")
    }
}