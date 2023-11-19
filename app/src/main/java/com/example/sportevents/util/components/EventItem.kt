package com.example.sportevents.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sportevents.util.models.UiEventModel
import java.time.ZonedDateTime

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

    val listColors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
    val customBrush = remember {
        Brush.linearGradient(
                    colors = listColors,
                    tileMode = TileMode.Mirror
                )
    }


    Row(
        modifier = modifier
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .background(customBrush),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(end = 10.dp)
        ) {
            //todo set default image when cannot fetch
            AsyncImage(
                model = eventModel.imageUrl,
                contentDescription = eventModel.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .background(Color.Gray)
                    .clip(
                        RoundedCornerShape(
                            topStart = 10.dp,
                            bottomStart = 10.dp,
                        )
                    )
            )
        }
        Column() {
            Text(
                text = eventModel.title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = eventModel.subtitle,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = formattedDate,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }

}