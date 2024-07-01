package com.example.ex4q5

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.ex4q5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var bounded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnNext.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
        }

        binding!!.editText.addTextChangedListener {
            val text = binding!!.editText.text

            if(text.isNotEmpty() && !bounded) {
                bounded = true
                bindService(Intent(this, MyService::class.java), serviceConnection, BIND_AUTO_CREATE)
                Log.d("TAG", "Service Bind")
            }
            if(text.isEmpty() && bounded) {
                bounded = false
                unbindService(serviceConnection)
                Log.d("TAG", "Service Unbind")
            }

            if(text.toString().length >= 12) {
                bounded = false
                unbindService(serviceConnection)
                Log.d("TAG", "Service Unbind")
            }

            var hasUpperCase = false
            var hasLowerCase = false
            for (char in text) {
                if (char.isUpperCase()) {
                    hasUpperCase = true
                }
                if (char.isLowerCase()) {
                    hasLowerCase = true
                }
            }
            if(text.toString().length > 7 && hasLowerCase && hasUpperCase) {
                bounded = false
                unbindService(serviceConnection)
                Log.d("TAG", "Service Unbind")
            }
        }
    }
}

private val serviceConnection: ServiceConnection = object : ServiceConnection {
    override fun onServiceConnected(className: ComponentName, iBinder: IBinder) {
        Log.d("TAG SERVICE", "onServiceConnected")
    }

    override fun onServiceDisconnected(arg0: ComponentName) {
        Log.d("TAG SERVICE", "onServiceDisconnected")
    }
}