package com.example.madpractical6_20012011003

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import com.example.madpractical6_20012011003.databinding.ActivityYouTubeBinding

class YouTubeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityYouTubeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityYouTubeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initYoutubePlayer()

        binding.gotoMain.setOnClickListener{
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)
            }
        }

    }

    private val youtubeId = "es4x5R-rV9s"
    @SuppressLint("SetJavaScriptEnabled")
    private fun initYoutubePlayer(){
        val webSettings: WebSettings = binding.youtubeWebView.settings
        webSettings.javaScriptEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        binding.youtubeWebView.loadUrl("https://www.youtube.com/embed/$youtubeId")
    }
}