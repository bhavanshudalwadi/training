package com.example.service_q_30

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var calculatorService: CalculatorService.CalculatorServiceBinder

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as CalculatorService.CalculatorServiceBinder
            calculatorService = binder
            Log.d("MainActivity", "Service connected")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("MainActivity", "Service disconnected")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Bind to the CalculatorService
        val intent = Intent(this, CalculatorService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)

        // Setup UI elements
        val editTextNum1 = findViewById<EditText>(R.id.editTextNum1)
        val editTextNum2 = findViewById<EditText>(R.id.editTextNum2)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        addButton.setOnClickListener {
            performCalculation("add", editTextNum1.text.toString(), editTextNum2.text.toString())
        }

        subtractButton.setOnClickListener {
            performCalculation("subtract", editTextNum1.text.toString(), editTextNum2.text.toString())
        }

        multiplyButton.setOnClickListener {
            performCalculation("multiply", editTextNum1.text.toString(), editTextNum2.text.toString())
        }

        divideButton.setOnClickListener {
            performCalculation("divide", editTextNum1.text.toString(), editTextNum2.text.toString())
        }
    }

    private fun performCalculation(operation: String, num1Str: String, num2Str: String) {
        try {
            val num1 = num1Str.toInt()
            val num2 = num2Str.toInt()
            val result = calculatorService.calculate(num1, num2, operation)
            Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(serviceConnection)
    }
}