package com.example.sportevents.util.components

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(
    uri: Uri,
    exoPlayer: ExoPlayer,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = {
        onDismiss()
    }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.DarkGray
        ) {
            Column() {
                Button(
                    onClick = { onDismiss() }
                ) {
                    Text(text = "X") //TODO set X icon, move to top right
                }
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
    onReady: () -> Unit
) {

    LaunchedEffect(
        key1 = Unit,
        block = { onReady() }
    )

    Surface(color = Color.Black) {
        Column(
            modifier = Modifier.size(200.dp), //TODO adjust player size
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