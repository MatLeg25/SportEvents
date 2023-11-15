package com.example.sportevents.domain.enum

import java.time.ZonedDateTime

enum class DayType {
    TODAY, TOMORROW, YESTERDAY, OTHER;

    companion object {
        fun fromZonedDateTime(date: ZonedDateTime): DayType {
            val today = ZonedDateTime.now()
            val todayDay = today.dayOfMonth
            val todayMonth = today.month
            val todayYear = today.year

            return if (todayYear != date.year && todayMonth != date.month) {
                DayType.OTHER
            } else {
                when {
                    (date.dayOfMonth == todayDay) -> DayType.TODAY
                    (date.dayOfMonth == todayDay + 1) -> DayType.TOMORROW
                    (date.dayOfMonth == todayDay - 1) -> DayType.YESTERDAY
                    else -> DayType.OTHER
                }
            }
        }
    }
}