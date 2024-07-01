package com.example.service_40

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TimeService : Service() {

    private val binder = TimeBinder()
    private var isServiceRunning = true

    inner class TimeBinder : Binder() {
        fun getService(): TimeService = this@TimeService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }


    override fun onUnbind(intent: Intent): Boolean {
        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }

    fun getCurrentTime(): String {
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        return sdf.format(Date())
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}