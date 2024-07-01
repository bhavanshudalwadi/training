package com.example.q25toq43.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.q25toq43.R
import com.example.q25toq43.databinding.ActivityQ36Binding

class q36 : AppCompatActivity() {
    private lateinit var binding : ActivityQ36Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityQ36Binding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}