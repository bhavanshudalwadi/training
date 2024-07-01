package com.example.q5

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeLang = findViewById<Button>(R.id.btnChangeLang)
        btnChangeLang.setOnClickListener {
            Log.d("TAG", AppCompatDelegate.getApplicationLocales()[0].toString())
            var appLocale: LocaleListCompat
            if(AppCompatDelegate.getApplicationLocales()[0].toString() == "hi") {
                appLocale = LocaleListCompat.forLanguageTags("en")
                Log.d("TAG", "en is set")
            }else {
                appLocale = LocaleListCompat.forLanguageTags("hi")
                Log.d("TAG", "hi is set")
            }
            AppCompatDelegate.setApplicationLocales(appLocale)
        }
    }
}