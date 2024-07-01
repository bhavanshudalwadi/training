package com.example.twel_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var num1 : EditText
    private lateinit var num2 : EditText
    private lateinit var btn : Button
    private lateinit var btn1 : Button
//    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        btn = findViewById(R.id.button)
        btn1 = findViewById(R.id.button2)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        var n1 = num1.text.toString()
        var n2 =  num2.text.toString()


        btn.setOnClickListener {
            val value1 = num1.text.toString()
            val value2 = num2.text.toString()

            if (value1.isNotEmpty() && value2.isNotEmpty()) {
                val result = value1.toInt() + value2.toInt()
                val result2 = value1.toInt() - value2.toInt()

                Toast.makeText(this, "Sum: $result minus: $result2", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }


        btn1.setOnClickListener {
            val value1 = num1.text.toString()
            val value2 = num2.text.toString()

            if (value1.isNotEmpty() && value2.isNotEmpty()) {
                val result = value1.toFloat() / value2.toFloat()
                val result2 = value1.toFloat() * value2.toFloat()


                Snackbar.make(findViewById(R.id.main),"division: $result multiply: $result2", Snackbar.LENGTH_LONG ).show()

            } else {
                Snackbar.make(findViewById(R.id.main),"Please enter both numbers", Snackbar.LENGTH_LONG ).show()

            }
        }




    }
}