package com.example.ex4q6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ex4q6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var bounded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnUpload.setOnClickListener {
            galleryLauncher.launch("image/*")
            startService(Intent(this, MyService::class.java))
            Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show()
        }
        binding!!.btnRemove.setOnClickListener {
            binding!!.ivPreview.setImageURI(null)
            stopService(Intent(this, MyService::class.java))
            Toast.makeText(this, "Service Stoped", Toast.LENGTH_LONG).show()
        }
    }

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val galleryUri = it
        try{
            binding!!.ivPreview.setImageURI(galleryUri)
        }catch(e:Exception){
            e.printStackTrace()
        }
    }
}