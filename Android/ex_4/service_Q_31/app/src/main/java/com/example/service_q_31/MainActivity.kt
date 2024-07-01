package com.example.service_q_31

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//quetion 31, 32..............


class MainActivity : AppCompatActivity() {

    private lateinit var calculatorService: CalculatorService.CalculatorServiceBinder
    private var isServiceBound = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as CalculatorService.CalculatorServiceBinder
            calculatorService = binder
            isServiceBound = true
            showToast("Connected to CalculatorService")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isServiceBound= false
            showToast("Disconnected from CalculatorService")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, CalculatorService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)

        // Create a notification channel
        createNotificationChannel()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isServiceBound) {
            unbindService(serviceConnection)
            isServiceBound = false
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "channel_id" // Unique channel ID
            val channelName = "Channel Name" // Name of the channel
            val channelDescription = "Channel Description" // Description of the channel
            val importance = NotificationManager.IMPORTANCE_DEFAULT // Importance level of the channel

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }

            // Register the channel with the system
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


}