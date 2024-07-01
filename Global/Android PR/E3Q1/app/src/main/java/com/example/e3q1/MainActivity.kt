package com.example.e3q1

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnShowToast).setOnClickListener {
            Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show()
            Snackbar.make(
                findViewById(R.id.constraintLayout),
                "Text Colored Successfully",
                Snackbar.LENGTH_LONG
            ).show()

            val text = "<font color=#cc0029>Bhavanshu</font> <font color=#ffcc00>Dalwadi</font>"
            findViewById<TextView>(R.id.txtColoredText).text = Html.fromHtml(text)
        }

        val txtClickableString = findViewById<TextView>(R.id.clickableString)
        txtClickableString.setOnClickListener {
            Toast.makeText(this, txtClickableString.text, Toast.LENGTH_LONG).show()
        }
    }
}