package com.example.service_q_31

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class CalculatorService : Service() {

    private val binder = CalculatorServiceBinder()

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    inner class CalculatorServiceBinder : Binder() {
        fun add(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }
}