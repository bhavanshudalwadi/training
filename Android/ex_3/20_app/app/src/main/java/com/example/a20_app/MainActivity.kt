package com.example.a20_app

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a20_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = ArrayList<String>()
        list.add("mango")
        list.add("apple")

        var adapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item, list
        )

        binding.spinner.adapter = adapter

        binding.button.setOnClickListener {

            var item = binding.editTextText.text.toString()
            if (item.isNotEmpty()) {
                list.add(item)
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "Item added to the spinner", Toast.LENGTH_SHORT).show()
                binding.editTextText.text.clear()
            }else{
                Toast.makeText(this, "Enter item to enter", Toast.LENGTH_SHORT).show()
            }
        }


    }
}