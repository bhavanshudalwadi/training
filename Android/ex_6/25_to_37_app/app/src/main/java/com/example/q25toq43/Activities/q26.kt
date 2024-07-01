package com.example.q25toq43.Activities

import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.q25toq43.databinding.ActivityQ26Binding


class q26 : AppCompatActivity() {
    private lateinit var binding: ActivityQ26Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQ26Binding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    val newTextSize =  10 + progress


                    binding.textView.setTextSize(newTextSize.toFloat())
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })


    }
}
