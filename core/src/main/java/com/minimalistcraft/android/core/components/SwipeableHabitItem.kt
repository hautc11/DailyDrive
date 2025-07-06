package com.minimalistcraft.android.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.minimalistcraft.android.core.R
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.design.Black100
import com.minimalistcraft.android.core.design.TitleMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeableHabitItem(
    modifier: Modifier = Modifier,
    id: Int,
    icon: Painter = painterResource(R.drawable.ic_default_habit),
    name: String,
    bgColor: Color = Color(0xFFCCE5E3),
    isCompleted: Boolean = false,
    onSwipeCompleted: (Int) -> Unit = {}
) {
    val swipeState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.StartToEnd) {
                onSwipeCompleted.invoke(id)
                false
            } else {
                true
            }
        }
    )
    SwipeToDismissBox(
        state = swipeState,
        backgroundContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF14AE5C))
                    .padding(20.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_marked_done),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        },
        enableDismissFromStartToEnd = true,
        enableDismissFromEndToStart = false
    ) {
        HabitItem(
            modifier = modifier,
            icon = icon,
            name = name,
            bgColor = bgColor,
            isCompleted = isCompleted
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitItem(
    modifier: Modifier = Modifier,
    icon: Painter = painterResource(R.drawable.ic_default_habit),
    name: String,
    bgColor: Color = Color(0xFFCCE5E3),
    isCompleted: Boolean = false,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(bgColor)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = "",
            tint = null
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = name,
            color = Black100,
            style = TitleMedium
        )
        if (isCompleted) {
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.ic_completed),
                contentDescription = "",
                tint = null
            )
        }
    }
}

@CustomPreview
@Composable
private fun DailyHabitPrev() {
    HabitItem(
        name = "Daily Habit",
        isCompleted = true
    )
}