package com.minimalistcraft.android.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.TitleBold

@Composable
fun Header(modifier: Modifier = Modifier, title: String) {
    Row(
        modifier
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = colors.mainTextColor,
            style = TitleBold
        )
    }
}

@CustomPreview
@Composable
private fun HeaderPrev() {
    ThemedPreview {
        Header(title = "Home")
    }
}