package com.example.sportevents.util.extension

import com.example.sportevents.domain.enum.DayType
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

//TODO move hardcoded string to StringRes
//TODO check if it takes into account different TimeZOnes
fun ZonedDateTime.getFormattedDate(): String {
    val dayType = DayType.fromZonedDateTime(this)

    return when (dayType) {
        DayType.TOMORROW -> "Tomorrow, ${getFormattedTime(this)}"
        DayType.YESTERDAY -> "Yesterday, ${getFormattedTime(this)}"
        DayType.TODAY -> "Today, ${getFormattedTime(this)}"
        DayType.OTHER -> "${this.dayOfMonth}.${this.month}.${this.year}"
    }
}

fun ZonedDateTime.getFormattedDate2(): String {
    val dayType = DayType.fromZonedDateTime(this)
    //TODO FIX BUG - problem with date formatting
    fun getDaysTo(date: ZonedDateTime, unit: ChronoUnit = ChronoUnit.HOURS): Int {
        val today = ZonedDateTime.now()
        val hoursDifference = unit.between(today, date).toInt()
        return if (hoursDifference <= 24) 1 else (hoursDifference / 24)

    }

    return when (dayType) {
        DayType.TODAY -> "Today, ${getFormattedTime(this)}"
        DayType.TOMORROW -> "Tomorrow, ${getFormattedTime(this)}"
        else -> "In ${getDaysTo(this)} days"
    }
}

fun getFormattedTime(date: ZonedDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return date.format(formatter)
}



