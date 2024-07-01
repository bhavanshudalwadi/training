package com.example.ex4q2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.editText)
        val startServiceButton: Button = findViewById<Button>(R.id.startServiceButton)
        val stopServiceButton: Button = findViewById<Button>(R.id.stopServiceButton)
        val btnNext: Button = findViewById<Button>(R.id.btnNext)

        startServiceButton.setOnClickListener {
            startService(Intent(this, MainService::class.java))
        }

        editText.addTextChangedListener {
            var str = editText.text.toString()
//            if(str.isNotEmpty()) {
//                stopService(Intent(this, MainService::class.java))
//            }
//            if(str.length >= 4) {
//                stopService(Intent(this, MainService::class.java))
//            }

            var cnt = 0
            for (i in str.indices) {
                val ch: Char = str[i]
                if (Character.isUpperCase(ch)) {
                    cnt++
                }
            }
            Log.d("TAG", cnt.toString())
            if(editText.text.toString().length > 11 && cnt >= 2) {
                stopService(Intent(this, MainService::class.java))
            }
        }

        stopServiceButton.setOnClickListener {
            stopService(Intent(this, MainService::class.java))
        }

        btnNext.setOnClickListener {
            val inputText = editText.text.toString()
            if(inputText == "Start Service") {
                startService(Intent(this, MainService::class.java))
            }else if(inputText == "Stop Service") {
                stopService(Intent(this, MainService::class.java))
            }
        }
    }
}