package com.example.ex4q5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ex4q5.databinding.ActivityService2Binding
import com.example.ex4q5.databinding.ActivityServiceBinding

class ServiceActivity2 : AppCompatActivity() {
    private var binding: ActivityService2Binding? = null
    private var bounded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityService2Binding.inflate(layoutInflater)
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