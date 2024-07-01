package com.example.brdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.provider.Telephony
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            Log.d("TAG", "Count: ${messages.count()}")

            val msgs = messages.filter { m -> m.originatingAddress!!.matches("..-KOTAKB".toRegex()) &&  m.messageBody!!.matches("Received.*".toRegex())}

            for (message in msgs) {
                val body = message.messageBody

                // Extracting amount
                val amountRegex = Regex("""Rs\.(\d+\.\d{2})""")
                val amountMatch = amountRegex.find(body)
                val amount = amountMatch?.groupValues?.get(1)

                // Extracting email
                val upiRegex = Regex("""from\s([^\s]+)\s""")
                val upiMatch = upiRegex.find(body)
                val upi = upiMatch?.groupValues?.get(1)

                // Extracting UPI reference
                val upiRefRegex = Regex("""Ref:(\d+)""")
                val upiRefMatch = upiRefRegex.find(body)
                val upiRef = upiRefMatch?.groupValues?.get(1)

//                amount, email, upiRef
            }
        }
    }
}