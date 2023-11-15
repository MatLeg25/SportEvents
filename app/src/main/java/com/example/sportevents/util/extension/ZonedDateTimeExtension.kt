package com.example.sportevents.util.extension

import com.example.sportevents.domain.enum.DayType
import java.time.ZonedDateTime

//TODO display leading zeros for hour and minute
fun ZonedDateTime.getFormattedDate(): String {
    val dayType = DayType.fromZonedDateTime(this)
    fun getFormattedTime() = "${this.hour}:${this.minute}"
    return when (dayType) {
        DayType.TOMORROW -> "Tomorrow, ${getFormattedTime()}"
        DayType.YESTERDAY -> "Yesterday, ${getFormattedTime()}"
        DayType.TODAY -> "Today, ${getFormattedTime()}"
        DayType.OTHER -> "${this.dayOfMonth}.${this.month}.${this.year}"
    }
}



