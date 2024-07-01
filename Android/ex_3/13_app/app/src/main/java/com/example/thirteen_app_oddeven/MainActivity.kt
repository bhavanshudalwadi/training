package com.example.thirteen_app_oddeven

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thirteen_app_oddeven.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btn.setOnClickListener {
                var num = binding.editText.text.toString()

                if (num.isNotEmpty()){
                    if(num.toInt() % 2 == 0){
                        Toast.makeText(this, "number is even", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this , "number is odd", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "enter proper number", Toast.LENGTH_SHORT).show()
                }
            }

        binding.btn1.setOnClickListener {
            var num = binding.editText.text.toString()

            if (num.isNotEmpty()){
                if(isPrime(num.toInt())){
                    Toast.makeText(this, "$num is a prime number", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(this, "$num is not a prime number", Toast.LENGTH_SHORT).show()

                }
            }else{
                Toast.makeText(this, "enter proper number", Toast.LENGTH_SHORT).show()
            }
        }



    }
    private fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }

        // Optimized loop to check divisibility up to square root of number
        val sqrtNumber = sqrt(number.toDouble()).toInt()
        for (i in 2..sqrtNumber) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}