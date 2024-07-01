package com.example.ex4q1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        Log.d("MyService", "onBind")
        return null
    }

    override fun onCreate() {
        Log.d("MyService", "onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("MyService", "onDestroy")
        super.onDestroy()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("MyService", "onUnbind")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        Log.d("MyService", "onRebind")
        super.onRebind(intent)
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        Log.d("MyService", "onTaskRemoved")
        super.onTaskRemoved(rootIntent)
    }

    override fun onTimeout(startId: Int) {
        Log.d("MyService", "onTimeout")
        super.onTimeout(startId)
    }
}