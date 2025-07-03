package com.minimalistcraft.android.core.design

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.minimalistcraft.android.core.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val TitleBold = TextStyle(
    fontFamily = Montserrat,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.sp,
    lineHeight = 32.sp
)

val TitleMedium = TextStyle(
    fontFamily = Montserrat,
    fontSize = 18.sp,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 0.1.sp,
    lineHeight = 20.sp
)

val LabelRegular = TextStyle(
    fontFamily = Montserrat,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
    letterSpacing = 0.1.sp,
    lineHeight = 20.sp
)

val BodyMedium = TextStyle(
    fontFamily = Montserrat,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.1.sp,
    lineHeight = 20.sp
)

val BodyTiny = TextStyle(
    fontFamily = Montserrat,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.5.sp,
    lineHeight = 16.sp
)