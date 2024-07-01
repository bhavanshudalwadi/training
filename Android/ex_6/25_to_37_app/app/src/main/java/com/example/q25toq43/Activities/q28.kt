package com.example.q25toq43.Activities

import android.os.Bundle
import android.text.InputFilter
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.q25toq43.R
import com.example.q25toq43.databinding.ActivityQ28Binding

class q28 : AppCompatActivity() {
    private lateinit var binding : ActivityQ28Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQ28Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(1))

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Clear the text input field
                binding.editText.text?.clear()

                // Adjust the maximum length of the text input field based on the seekBar progress
                val maxLength = progress + 1 // Adding 1 to avoid 0 length
                binding.editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })



    }
}