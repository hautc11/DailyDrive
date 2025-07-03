package com.minimalistcraft.android.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.design.AppTheme
import com.minimalistcraft.android.core.design.LabelRegular
import com.minimalistcraft.android.core.design.TabActiveColor

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {}
) {
    Surface(
        modifier = modifier
            .padding(end = 10.dp)
            .clip(RoundedCornerShape(50)),
        color = if (isSelected) TabActiveColor else Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(1.dp, AppTheme.colors.strokeBorder),
                    shape = RoundedCornerShape(50)
                )
                .toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectionChanged(label)
                    }
                )
        ) {
            Text(
                text = label,
                style = LabelRegular,
                color = AppTheme.colors.mainTextColor,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
            )
        }
    }
}

@CustomPreview
@Composable
private fun ChipPreview() {
    ThemedPreview {
        Row {
            Chip(label = "All", isSelected = true)
            Chip(label = "Morning")
        }
    }
}