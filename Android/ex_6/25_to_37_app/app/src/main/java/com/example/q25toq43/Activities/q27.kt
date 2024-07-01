package com.example.q25toq43.Activities

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.q25toq43.databinding.ActivityQ27Binding

class q27 : AppCompatActivity() {
    private lateinit var binding: ActivityQ27Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityQ27Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        val initialWidth = binding.imageView.measuredWidth
        val initialHeight = binding.imageView.measuredHeight
        val widthIncrement = 10
        val heightIncrement = 10


        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                val layoutParams = binding.imageView.layoutParams
                layoutParams.width = initialWidth + (progress * widthIncrement)
                layoutParams.height = initialHeight + (progress * heightIncrement)
                binding.imageView.layoutParams = layoutParams
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
}