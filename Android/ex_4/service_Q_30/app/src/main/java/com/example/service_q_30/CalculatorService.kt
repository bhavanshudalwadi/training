package com.example.service_q_30

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class CalculatorService : Service() {
    private val binder = CalculatorServiceBinder()

    companion object {
        const val TAG = "CalculatorService"
    }

    override fun onCreate(){
        super.onCreate()
        Log.d(TAG,"service created")
    }

//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Log.d(TAG, "Service started")
//        // Add your service logic here
//
//        // If you want the service to continue running until explicitly stopped
//        return START_STICKY
//    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "IntentService destroyed")
    }
    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
    inner class CalculatorServiceBinder : Binder() {
        fun calculate(num1: Int, num2: Int, operation: String): Int {
            return when (operation) {
                "add" -> num1 + num2
                "subtract" -> num1 - num2
                "multiply" -> num1 * num2
                "divide" -> num1 / num2
                else -> throw IllegalArgumentException("Invalid operation")
            }
        }
    }
}