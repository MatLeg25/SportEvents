package com.example.sportevents.domain.enum

import java.time.ZonedDateTime

enum class DayType {
    TODAY, TOMORROW, YESTERDAY, OTHER;

    companion object {
        fun fromZonedDateTime(zonedDateTime: ZonedDateTime): DayType {
            val todayDate = ZonedDateTime.now().toLocalDate()
            val zonedDate = zonedDateTime.toLocalDate()

            return when(todayDate) {
                zonedDate -> DayType.TODAY
                zonedDate.plusDays(1) -> DayType.TOMORROW
                zonedDate.minusDays(1) -> DayType.YESTERDAY
                else -> DayType.OTHER
            }
        }
    }
}