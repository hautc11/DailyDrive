package com.minimalistcraft.android.core.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChipGroup(modifier: Modifier = Modifier, chips: List<String>) {
    LazyRow {
        items(chips) {
            Chip(
                modifier = modifier,
                label = it,
                isSelected = false,
                onSelectionChanged = { }
            )
        }
    }
}