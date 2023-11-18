package com.example.sportevents.util.components

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(
    uri: Uri,
    exoPlayer: ExoPlayer,
    onDismiss: () -> Unit,
) {
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = { onDismiss() },
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = Color.DarkGray
        ) {
            Column() {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close",
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable { onDismiss() }
                        .shadow(elevation = 4.dp),
                    tint = Color.White
                )
                ContentView(
                    exoPlayer = exoPlayer,
                    onReady = {
                        exoPlayer.setMediaItem(
                            MediaItem.fromUri(uri)
                        )
                        exoPlayer.prepare()
                    }
                )
            }
        }
    }

}

@Composable
fun ContentView(
    exoPlayer: ExoPlayer,
    onReady: () -> Unit,
) {

    LaunchedEffect(
        key1 = Unit,
        block = { onReady() }
    )

    Surface(color = Color.Black) {
        Column(
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            verticalArrangement = Arrangement.Center
        ) {
            AndroidView(
                factory = {
                    PlayerView(it).also {
                        it.player = exoPlayer
                    }
                },
                update = { }
            )
        }
    }
}