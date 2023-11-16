package com.example.sportevents.util.extension

import com.example.sportevents.domain.enum.DayType
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

//TODO check if it takes into account different TimeZOnes
fun ZonedDateTime.getFormattedDate(): String {
    val dayType = DayType.fromZonedDateTime(this)

    fun getFormattedTime(): String {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return this.format(formatter)
    }

    return when (dayType) {
        DayType.TOMORROW -> "Tomorrow, ${getFormattedTime()}"
        DayType.YESTERDAY -> "Yesterday, ${getFormattedTime()}"
        DayType.TODAY -> "Today, ${getFormattedTime()}"
        DayType.OTHER -> "${this.dayOfMonth}.${this.month}.${this.year}"
    }
}



