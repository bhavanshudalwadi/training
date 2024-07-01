package com.example.service_q_37

import MusicService
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start_button)
        val stopButton = findViewById<Button>(R.id.stop_button)

        startButton.setOnClickListener {
            val serviceIntent = Intent(this, MusicService::class.java)
            startService(serviceIntent)
        }

        stopButton.setOnClickListener {
            val serviceIntent = Intent(this, MusicService::class.java)
            stopService(serviceIntent)
        }
    }
}