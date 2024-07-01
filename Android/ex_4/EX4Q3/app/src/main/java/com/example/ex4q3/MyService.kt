package com.example.ex4q3

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        Log.d("SERVICE", "onBind")
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("SERVICE", "onStartCommand")
        Thread {
            stopSelf()
            Thread.sleep(900000)
        }.start()
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.d("SERVICE", "onDestroy")
        super.onDestroy()
    }
}