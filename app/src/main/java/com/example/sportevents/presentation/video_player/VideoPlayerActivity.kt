package com.example.sportevents.presentation.video_player

import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.sportevents.ui.theme.SportEventsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoPlayerActivity: ComponentActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var exoPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        playerView = PlayerView(this)
        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer

        setContent {
            SportEventsTheme {
                Column {
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
                        onClick = { finish() }
                    ) {
                        Text(text = "END")
                    }
                }


            }
        }
    }

    override fun onResume() {
        super.onResume()

        exoPlayer.playWhenReady = true
        exoPlayer.play()
    }

    override fun onPause() {
        super.onPause()

        exoPlayer.pause()
        exoPlayer.playWhenReady = false
    }

    override fun onStop() {
        super.onStop()

        exoPlayer.pause()
        exoPlayer.playWhenReady = false
    }

    override fun onDestroy() {
        super.onDestroy()

        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        exoPlayer.stop()
        exoPlayer.clearMediaItems()
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