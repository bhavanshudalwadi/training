package com.example.ex4q5

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.ex4q5.databinding.ActivityMainBinding
import com.example.ex4q5.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private var binding: ActivityServiceBinding? = null
    private var bounded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnNext.setOnClickListener {
            startActivity(Intent(this, ServiceActivity2::class.java))
        }

        binding!!.editOne.addTextChangedListener {
            onTextChange()
            if(binding!!.editOne.text.isEmpty() && bounded) {
                unbindService(serviceConnection)
                bounded = false
                binding!!.editOne.visibility = View.GONE
            }
        }
        binding!!.editTwo.addTextChangedListener {
            onTextChange()
        }
    }

    fun onTextChange() {
        val text1 = binding!!.editOne.text
        val text2 = binding!!.editTwo.text

        if(text1.isNotEmpty() && text2.isNotEmpty()) {
            Log.d("TAG", "Both Empty")
            bindService(Intent(this, MyService::class.java), serviceConnection, BIND_AUTO_CREATE)
            bounded = true
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