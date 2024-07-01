package com.example.addsub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAddSub).setOnClickListener {
            var n1 = findViewById<EditText>(R.id.editNumOne).text as Double
            var n2 = findViewById<EditText>(R.id.editNumTwo).text as Double

            var sum:Double = n1+n2
            var sub:Double = n1+n2

            Toast.makeText(this, "Add: ${sum} Sub: ${sub}", Toast.LENGTH_LONG).show()
        }
    }
}