package com.example.sportevents.presentation.schedule_screen.components

import androidx.compose.runtime.Composable
import com.example.sportevents.domain.enum.DayType
import com.example.sportevents.util.extension.getFormattedTime
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

//TODO validate this formatter
@Composable
fun dateFormatterSchedule(date: ZonedDateTime): String {
    val dayType = DayType.fromZonedDateTime(date)

    fun getDaysTo(date: ZonedDateTime, unit: ChronoUnit = ChronoUnit.HOURS): Int {
        val today = ZonedDateTime.now()
        val hoursDifference = unit.between(today, date).toInt()
        return if (hoursDifference <= 24) 1 else (hoursDifference / 24)
    }

    return when (dayType) {
        DayType.TODAY -> "Today, ${date.getFormattedTime()}"
        DayType.TOMORROW -> "Tomorrow, ${date.getFormattedTime()}"
        else -> "In ${getDaysTo(date)} days"
    }
}

