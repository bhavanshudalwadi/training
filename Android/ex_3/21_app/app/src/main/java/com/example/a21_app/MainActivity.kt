package com.example.a21_app

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a21_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list= ArrayList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        var adapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item, list
        )
        binding.spinner.adapter = adapter

        binding.btnAdd.setOnClickListener { 
            var num = binding.addNum.text.toString()
            if(num.isNotEmpty()){

                list.add(num.toInt())
                Toast.makeText(this, "number added to list", Toast.LENGTH_SHORT).show()
                binding.addNum.text.clear()
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnShow.setOnClickListener {
            var intent  = Intent(this,MainActivity2::class.java)
            intent.putExtra("list",list.toIntArray())
            startActivity(intent)
        }
    }

}