package com.example.service_40

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var timeService: TimeService
    private var isServiceBound = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as TimeService.TimeBinder
            timeService = binder.getService()
            isServiceBound = true
            updateCurrentTime()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isServiceBound = false
        }
    }

    private lateinit var bindButton: Button
    private lateinit var unbindButton: Button
    private lateinit var currentTimeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        bindButton = findViewById(R.id.bindButton)
        unbindButton = findViewById(R.id.unbindButton)
        currentTimeTextView = findViewById(R.id.currentTimeTextView)

        bindButton.setOnClickListener {
            bindService()
        }

        unbindButton.setOnClickListener {
            unbindService()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService()
    }

    private fun bindService() {
        val intent = Intent(this, TimeService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    private fun unbindService() {
        if (isServiceBound) {
            unbindService(connection)
            isServiceBound = false
        }
    }

    private fun updateCurrentTime() {
        val currentTime = timeService.getCurrentTime()
        currentTimeTextView.text = currentTime
    }
}