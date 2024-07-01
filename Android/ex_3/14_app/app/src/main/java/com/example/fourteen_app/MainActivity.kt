package com.example.fourteen_app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fourteen_app.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shape = resources.getStringArray(R.array.Shape)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, shape
        )
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                if (binding.spinner.selectedItem == "Circle") {

                    binding.radious.visibility = View.VISIBLE
                    binding.length.visibility = View.GONE
                    binding.breath.visibility = View.GONE

                } else {
                    binding.radious.visibility = View.GONE
                    binding.length.visibility = View.VISIBLE
                    binding.breath.visibility = View.VISIBLE
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

                Snackbar.make(binding.main, "nothing selected", Snackbar.LENGTH_SHORT).show()

            }
        }

        binding.btn.setOnClickListener {
            if (binding.spinner.selectedItem == "Circle") {

                if (binding.radious.text.toString().isEmpty()) {
                    Snackbar.make(binding.main, "enter radious", Snackbar.LENGTH_SHORT).show()

                } else {
                    var rad = binding.radious.text.toString().toFloat()

                    var area = (3.14) * rad * rad
                    Snackbar.make(
                        this,
                        binding.main,
                        "area of circle if $area",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                }
            } else {
                if (binding.length.text.toString().isEmpty() && binding.breath.text.toString()
                        .isEmpty()
                ) {
                    Snackbar.make(binding.main, "enter length and breath", Snackbar.LENGTH_SHORT)
                        .show()

                } else {


                    var l = binding.length.text.toString().toFloat()
                    var b = binding.breath.text.toString().toFloat()

                    var area = l * b
                    Snackbar.make(
                        this,
                        binding.main,
                        "area of Square if $area",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }
        }


    }
}