package com.example.a21_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.a21_app.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val reqList = intent.getIntArrayExtra("list") // Retrieve IntArray from Intent
        val resultList = reqList?.filter { it % 2 != 0 }


        binding.textView.text = resultList?.joinToString("\n")
    }
}