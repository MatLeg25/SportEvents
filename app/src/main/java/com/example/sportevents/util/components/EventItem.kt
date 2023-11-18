package com.example.sportevents.util.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.sportevents.R
import com.example.sportevents.presentation.schedule_screen.components.dateFormatterSchedule
import com.example.sportevents.util.models.UiEventModel
import java.time.ZonedDateTime

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
fun EventItem(
    modifier: Modifier = Modifier,
    eventModel: UiEventModel = UiEventModel(
        ZonedDateTime.now(),
        "bbbb",
        "ccc",
        "ddd",
        "eee"
    ),
    formattedDate: String = "1234",
) {
    val backgroundGradient = Brush.linearGradient(
        0.0f to MaterialTheme.colorScheme.primary,
        500.0f to MaterialTheme.colorScheme.secondary,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Row(
        modifier = modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(backgroundGradient),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .size(72.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = eventModel.imageUrl,
                    builder = {
                        crossfade(true)
                        error(R.drawable.ic_launcher_background) //todo set error image
                        fallback(R.drawable.ic_launcher_background) //todo set no data image
                    }
                ),
                contentDescription = eventModel.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .background(Color.Gray)
            )
        }
        Column() {
            Text(
                text = eventModel.title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = eventModel.subtitle,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = formattedDate,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }

}