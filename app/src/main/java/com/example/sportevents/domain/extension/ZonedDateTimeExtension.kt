package com.example.sportevents.domain.extension

import com.example.sportevents.domain.enum.DayType
import java.time.ZonedDateTime

fun ZonedDateTime.getFormattedDate(): String {
    val dayType = DayType.fromZonedDateTime(this)
    return when (dayType) {
        DayType.TOMORROW -> "Tomorrow, ${this.hour}:${this.minute}"
        DayType.YESTERDAY -> "Yesterday, ${this.hour}:${this.minute}"
        DayType.TODAY -> "Today, ${this.hour}:${this.minute}"
        DayType.OTHER -> "${this.dayOfMonth}.${this.month}.${this.year}"
    }
}



