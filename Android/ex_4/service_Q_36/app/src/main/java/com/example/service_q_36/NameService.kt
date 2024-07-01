package com.example.service_q_36

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class NameService : Service() {

     val binder = NameBinder()

    inner class NameBinder : Binder() {
        fun getName(): String {
            return "Nupur Paliwal"
        }

        fun getService(): NameService {
            return this@NameService
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return binder
    }
}
