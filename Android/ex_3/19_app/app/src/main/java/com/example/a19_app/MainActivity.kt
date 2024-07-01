package com.example.a19_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a19_app.databinding.ActivityMainBinding
// cahnge title with edit text
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeTitleBtn.setOnClickListener {
            var title = binding.titleEditTxt.text
            if (title.toString().isNotEmpty()) {
                binding.titleTv.text = title
            } else {
                Toast.makeText(this, "enter title in edit box", Toast.LENGTH_SHORT).show()
            }
        }

    }
}