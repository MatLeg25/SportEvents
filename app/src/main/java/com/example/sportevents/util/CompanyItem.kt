package com.example.sportevents.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportevents.domain.model.SportEvent

@Composable
@Preview
fun EventItem(
    event: SportEvent = SportEvent(
        "aaaaa",
        "bbbb",
        "ccc",
        "ddd",
        "eee",
        "fff",
    ),
    modifier: Modifier = Modifier
) {
    Row(
    modifier = modifier.background(Color.Gray),
    verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = event.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = event.subtitle,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = event.date,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )

        }
    }

}