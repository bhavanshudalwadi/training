package com.example.ten_app

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import com.example.ten_app.MainActivity2
import com.example.ten_app.R

class MainActivity : AppCompatActivity() {

    private lateinit var imageView1: ImageView
    private lateinit var btnCapture1: Button
    private lateinit var imageView2: ImageView
    private lateinit var btnCapture2: Button
    private lateinit var editText: EditText
    private lateinit var btn3 : Button
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize views
        imageView1 = findViewById(R.id.imageView1)
        btnCapture1 = findViewById(R.id.btnCapture1)
        imageView2 = findViewById(R.id.imageView2)
        btnCapture2 = findViewById(R.id.btnCapture2)
        editText = findViewById(R.id.edit_txt)
        btn3 = findViewById(R.id.btnCapture3)

        // Register activity result contract for capturing image
        val startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val capturedImage = result.data?.extras?.get("data") as? Bitmap
                imageView1.setImageBitmap(capturedImage)
            } else {
                Toast.makeText(this, "Capture image failed", Toast.LENGTH_SHORT).show()
            }
        }




        // Set click listener for capturing image from camera
        btnCapture1.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startForResult.launch(intent)
        }

        // Set click listener for selecting image from gallery
        btnCapture2.setOnClickListener {
            openGallery()
        }



        btn3.setOnClickListener{
            var intent = Intent(this@MainActivity,MainActivity2::class.java)
            var s  = editText.text.toString();
            intent.putExtra("key",s)
            startActivity(intent)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            PICK_IMAGE_REQUEST
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val selectedImageUri = data.data
            imageView2.setImageURI(selectedImageUri)
        } else {
            Toast.makeText(this, "Image selection failed", Toast.LENGTH_SHORT).show()
        }
    }
}
