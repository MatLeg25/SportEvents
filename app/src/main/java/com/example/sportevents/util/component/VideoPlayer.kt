package com.example.sportevents.util.component

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
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
    playerView: PlayerView,
    exoPlayer: ExoPlayer,
    playVideo: Boolean,
    onDismiss: () -> Unit
) {
    if (playVideo) {
        Dialog(onDismissRequest = {
            onDismiss()
        }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.DarkGray
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                ) {
                    ContentView(
                        playerView = playerView,
                        onReady = {
                            exoPlayer.setMediaItem(
                                MediaItem.fromUri(
                                    Uri.parse("https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o/promo.mp4?alt=media")
                                )
                            )
                            exoPlayer.prepare()
                        }
                    )
                    Button(
                        onClick = { onDismiss()}
                    ) {
                        Text(text = "END")
                    }
                }
            }
        }
    }

}

@Composable
fun ContentView(
    playerView: PlayerView,
    onReady: () -> Unit
) {

    LaunchedEffect(
        key1 = Unit,
        block = { onReady() }
    )

    Surface(color = Color.Black) {
        Column(
            modifier = Modifier.size(100.dp),
            verticalArrangement = Arrangement.Center
        ) {
            AndroidView(
                factory = {
                    playerView
                },
                //modifier = Modifier.wrapContentSize(),
                modifier = Modifier.size(100.dp),
                update = { }
            )
        }
    }
}