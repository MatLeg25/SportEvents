package com.example.sportevents.util.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.sportevents.R
import com.example.sportevents.domain.model.SportEvent
import com.example.sportevents.util.extension.getFormattedDate
import java.time.ZonedDateTime

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun EventItem(
    modifier: Modifier = Modifier,
    event: SportEvent = SportEvent(
        ZonedDateTime.now(),
        "bbbb",
        "ccc",
        "ddd",
        "eee",
        "fff",
    )
) {
    Row(
    modifier = modifier.background(Color.White),
    verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .size(72.dp)
                .background(Color.LightGray)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = event.imageUrl,
                    builder = {
                        crossfade(true)
                        error(R.drawable.ic_launcher_background) //todo set error image
                    }
                ),
                contentDescription = event.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight().aspectRatio(1f)
            )
        }
        Column() {
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
                text = event.date.getFormattedDate(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }

}