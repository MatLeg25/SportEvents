package com.example.sportevents.presentation.util.components

import androidx.compose.runtime.Composable
import com.example.sportevents.domain.enum.DayType
import com.example.sportevents.presentation.util.extension.getFormattedTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun dateFormatter(date: ZonedDateTime): String {
    val dayType = DayType.fromZonedDateTime(date)

    return when (dayType) {
        DayType.TOMORROW -> "Tomorrow, ${date.getFormattedTime()}"
        DayType.YESTERDAY -> "Yesterday, ${date.getFormattedTime()}"
        DayType.TODAY -> "Today, ${date.getFormattedTime()}"
        else -> DateTimeFormatter.ofPattern("dd.MM.LLLL").format(date)
    }
}