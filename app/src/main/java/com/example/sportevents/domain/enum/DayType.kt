package com.example.sportevents.domain.enum

import java.time.ZonedDateTime

enum class DayType {
    TODAY, TOMORROW, YESTERDAY, OTHER;

    companion object {
        fun fromZonedDateTime(zonedDateTime: ZonedDateTime): DayType {
            val todayDate = ZonedDateTime.now().toLocalDate()
            val zonedDate = zonedDateTime.toLocalDate()

            return when(zonedDate) {
                todayDate -> DayType.TODAY
                todayDate.plusDays(1) -> DayType.TOMORROW
                todayDate.minusDays(1) -> DayType.YESTERDAY
                else -> DayType.OTHER
            }
        }
    }
}