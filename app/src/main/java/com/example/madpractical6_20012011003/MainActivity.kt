package com.example.madpractical6_20012011003

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.madpractical6_20012011003.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initVideoPlayer()

        binding.gotoYouTube.setOnClickListener{
            intent = Intent(this,YouTubeActivity::class.java).apply {
                startActivity(intent)
            }
        }

    }
    private fun initVideoPlayer(){
        val mediaController = MediaController(this)
        val uri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.thestoryoflight)
        binding.myVideoView.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myVideoView)
        binding.myVideoView.setVideoURI(uri)
        binding.myVideoView.requestFocus()
        binding.myVideoView.start()
    }
}