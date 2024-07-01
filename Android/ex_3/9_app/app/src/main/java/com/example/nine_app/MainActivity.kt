package com.example.nine_app

import android.os.Bundle
import android.text.Html
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView = findViewById<TextView>(R.id.color_txt)
        textView.text =
            Html.fromHtml(getString(R.string.multi_color_text), Html.FROM_HTML_MODE_LEGACY)
        var hbd = findViewById<TextView>(R.id.hbd)

        textView.setOnClickListener {
            Toast.makeText(this, "this is clickable color tv" + textView.text, Toast.LENGTH_SHORT).show()
        }
        hbd.setOnClickListener {
            Toast.makeText(this, "this is clickable hbd tv" + hbd.text, Toast.LENGTH_SHORT).show()
        }
    }
}