package com.minimalistcraft.android.dailydrive.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.minimalistcraft.android.core.annotation.CustomPreview
import com.minimalistcraft.android.core.annotation.ThemedPreview
import com.minimalistcraft.android.core.components.ChipGroup
import com.minimalistcraft.android.core.components.DailyHabit
import com.minimalistcraft.android.core.components.Header
import com.minimalistcraft.android.core.components.RepeatTypeTab
import com.minimalistcraft.android.core.design.IndicatorTextColorLight
import com.minimalistcraft.android.dailydrive.R
import com.minimalistcraft.android.dailydrive.utils.displayName
import com.minimalistcraft.android.domain.model.RepeatType

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Header(title = stringResource(R.string.home))
        HomeContent()
    }
}

@Composable
fun HomeContent() {
    val context = LocalContext.current
    val repeatTypes = listOf(RepeatType.DAILY, RepeatType.WEEKLY, RepeatType.MONTHLY).map {
        it.displayName(context)
    }

    Column(modifier = Modifier.padding(24.dp)) {
        RepeatTypeTab(
            items = repeatTypes
        )
        Spacer(Modifier.height(24.dp))
        ChipGroup(chips = listOf("All", "Morning", "Afternoon", "Evening"))
        Spacer(Modifier.height(16.dp))
        HabitList()
    }
}

@Composable
fun HabitList() {
    Column {
        DailyHabit(
            icon = painterResource(R.drawable.ic_profile_selected),
            name = "Daily Habit",
            bgColor = IndicatorTextColorLight
        )
    }
}

@CustomPreview
@Composable
private fun HomeScrPreview() {
    ThemedPreview {
        HomeScreen()
    }
}