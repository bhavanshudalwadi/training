package com.example.ex4q5

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.ex4q5.databinding.ActivityServiceBinding

class MyService : Service() {
    private var binding: ActivityServiceBinding? = null

    override fun onBind(intent: Intent): IBinder? {
        binding = ActivityServiceBinding.inflate(LayoutInflater.from(applicationContext))
        Log.d("SERVICE", "onBind")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("SERVICE", "onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("SERVICE", "onDestroy")
        super.onDestroy()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        binding!!.txtImg.visibility = View.GONE
        return super.onUnbind(intent)
    }
}