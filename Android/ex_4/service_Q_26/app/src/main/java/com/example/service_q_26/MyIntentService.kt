package com.example.service_q_26

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.IBinder
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    companion object {
        const val TAG = "MyIntentService"
    }

    override fun onHandleIntent(intent: Intent?) {
        // This method is executed on a background thread
        // Do your background work here

        // Simulating a task by logging a message
        Log.d(TAG, "IntentService started")

        // Simulate some processing time
        Thread.sleep(3000)

        Log.d(TAG, "IntentService finished")
    }

    override fun onCreate(){
        super.onCreate()
        Log.d(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service started")
        // Add your service logic here

        // If you want the service to continue running until explicitly stopped
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "IntentService destroyed")
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}