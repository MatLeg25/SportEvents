package com.example.sportevents.presentation.util.extension

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun ZonedDateTime.getFormattedTime(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return this.format(formatter)
}


