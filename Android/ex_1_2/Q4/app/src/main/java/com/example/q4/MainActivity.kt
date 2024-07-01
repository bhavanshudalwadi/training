package com.example.q4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnOpenAct: Button =  findViewById(R.id.btnOpenAct);

        btnOpenAct.setOnClickListener {
            var i = Intent(this, AnotherActivity::class.java)
            startActivity(i)
        }
    }
}