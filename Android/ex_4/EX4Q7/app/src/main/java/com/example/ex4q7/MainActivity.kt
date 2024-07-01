package com.example.ex4q7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ex4q7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlayPause.setOnClickListener {
            if(!isPlaying) {
                val i= Intent(this, MusicService::class.java)
                i.putExtra("MODE", "PLAY")
                startService(i)
                binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_pause_circle_24))
                binding.btnStop.visibility = View.VISIBLE
                isPlaying = true
            }else {
                val i= Intent(this, MusicService::class.java)
                i.putExtra("MODE", "PAUSE")
                startService(i)
                binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_play_circle_24))
                isPlaying = false
            }
        }

        binding.btnStop.setOnClickListener {
            val i= Intent(this, MusicService::class.java)
            i.putExtra("MODE", "STOP")
            startService(i)
            binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_play_circle_24))
            binding.btnStop.visibility = View.GONE
            isPlaying = false
        }
    }
}