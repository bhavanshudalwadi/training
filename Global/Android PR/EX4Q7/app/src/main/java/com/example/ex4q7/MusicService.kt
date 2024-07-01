package com.example.ex4q7

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
    private var player: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("SERVICE", "onCreate")
        val ringtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        player = MediaPlayer.create(this, ringtone)
        player?.isLooping = true
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val mode = intent?.extras?.getString("MODE")
        Log.d("SERVICE", "Mode: $mode")
        if(mode.equals("PLAY")) {
            player?.start()
        }
        if(mode.equals("PAUSE")) {
            player?.pause()
        }
        if(mode.equals("STOP")) {
            stopSelf()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d("SERVICE", "onDestroy")
        super.onDestroy()
        player?.stop()
        player?.release()
    }
}