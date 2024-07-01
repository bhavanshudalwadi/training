package com.example.q4

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.net.URI

class AnotherActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        var btnOpenURL: Button =  findViewById(R.id.btnOpenURL);

        btnOpenURL.setOnClickListener {
            var i = Intent(Intent.ACTION_VIEW, Uri.parse("https://bhavanshudalwadi.netlify.app/"))
            startActivity(i)
        }
    }
}