package com.example.crudapi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import android.provider.Telephony
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            Log.d("TAG", "Count: ${messages.count()}")
            for (message in messages) {
                val sender = message.originatingAddress
                val body = message.messageBody

                val preferences = PreferenceManager.getDefaultSharedPreferences(context)
                val editor = preferences.edit()
                editor.putString("MSG", preferences.getString("MSG", "") + "\n" + "Sender: $sender Body: $body")
                editor.apply()
            }
        }
    }
}