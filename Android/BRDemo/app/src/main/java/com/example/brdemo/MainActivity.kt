package com.example.brdemo

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestSmsPermission()

//        var receiver: MyReceiver = MyReceiver()
//        var intentFilter: IntentFilter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            Log.d("TAG","SDK version > 33")
//            registerReceiver(receiver, intentFilter, RECEIVER_EXPORTED)
//        }

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        findViewById<TextView>(R.id.tv_result).text = preferences.getString("MSG", "")
    }

    private fun requestSmsPermission() {
        val permission: String = android.Manifest.permission.RECEIVE_SMS
        val grant = ContextCompat.checkSelfPermission(this, permission)
        if (grant != PackageManager.PERMISSION_GRANTED) {
            val permission_list = arrayOfNulls<String>(1)
            permission_list[0] = permission
            ActivityCompat.requestPermissions(this, permission_list, 1)
        }
    }
}