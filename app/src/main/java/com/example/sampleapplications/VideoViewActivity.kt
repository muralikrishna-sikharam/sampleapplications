package com.example.sampleapplications

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoViewActivity : AppCompatActivity() {
    var videoView: VideoView? = null
    var but_Video_View: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)
        videoView = findViewById(R.id.video_View)
        but_Video_View = findViewById(R.id.button_Video_View)
        but_Video_View?.setOnClickListener {
            videoView?.setVideoPath("android.resource://" + packageName + "/" + R.raw.one)
            var mediaPlayer = MediaController(this)
            mediaPlayer.setAnchorView(videoView)
            videoView?.setMediaController(mediaPlayer)
            videoView?.start()
            videoView?.visibility = View.VISIBLE
            but_Video_View?.visibility = View.GONE
        }
    }
}