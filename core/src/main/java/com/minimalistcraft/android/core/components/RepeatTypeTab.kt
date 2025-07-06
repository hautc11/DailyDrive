package com.minimalistcraft.android.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.design.AppTheme.colors
import com.minimalistcraft.android.core.design.MainTextColorDark
import com.minimalistcraft.android.core.design.TabActiveColor
import com.minimalistcraft.android.core.design.TitleMedium

@Composable
fun RepeatTypeTab(
    modifier: Modifier = Modifier,
    items: List<String>,
    onTabSelected: (String) -> Unit = {}
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedIndex,
        containerColor = colors.tabBackground,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
        indicator = { tabPositions ->
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedIndex])
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(4.dp))
                    .background(TabActiveColor)
                    .zIndex(1f)
            )
        },
        divider = {},
        tabs = {
            items.forEachIndexed { index, text ->
                val isSelected = selectedIndex == index
                Tab(
                    modifier = Modifier.zIndex(2f),
                    selected = isSelected,
                    onClick = {
                        selectedIndex = index
                        onTabSelected.invoke(items[index])
                    },
                    text = {
                        Text(
                            text = text,
                            color = if (isSelected) MainTextColorDark else colors.mainTextColor,
                            style = TitleMedium
                        )
                    })
            }
        })
}

@CustomPreview
@Composable
private fun RepeatTypeTabPrev() {
    ThemedPreview {
        RepeatTypeTab(items = listOf("A", "B", "C"))
    }
}