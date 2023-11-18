package com.example.sportevents.util.models

import android.net.Uri
import java.time.ZonedDateTime

data class UiEventModel(
    val date: ZonedDateTime,
    val id: String,
    val imageUrl: String,
    val subtitle: String,
    val title: String,
    val videoUri: Uri? = null
)