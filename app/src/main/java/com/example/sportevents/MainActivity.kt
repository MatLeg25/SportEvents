package com.example.sportevents

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.sportevents.presentation.schedule_screen.ScheduleScreen
import com.example.sportevents.ui.theme.SportEventsTheme
import com.example.sportevents.util.component.VideoPlayer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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

                //TODO  MOVE playVideo tto VIEWMODEL
                var playVideo by remember { mutableStateOf(true) }

                //TODO  CONTROL onDismiss behaviour from VIEWMODEL
                fun dismissVideoPlayer() {
                    playVideo = false
                    exoPlayer.pause()
                    exoPlayer.playWhenReady = false
                }


                ScheduleScreen()
                if (playVideo) {
                    VideoPlayer(
                        playerView = playerView,
                        exoPlayer = exoPlayer,
                        playVideo = playVideo,
                        onDismiss = { dismissVideoPlayer() }
                    )
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


