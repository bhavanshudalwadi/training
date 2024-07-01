package com.example.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val switch1=findViewById<Switch>(R.id.switch2)
        val progress=findViewById<ProgressBar>(R.id.progressBar)

        switch1.isChecked=true


    }
}

