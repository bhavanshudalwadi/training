package com.example.ex3camera

import android.R.attr
import android.R.attr.bitmap
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnCaptureImg).setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera_intent, 123)
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            val i = Intent(this, SecondaryActivity::class.java)
            i.putExtra("Content", "Bhavanshu Dalwadi")
            startActivity(i)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123) {
            val photo = data?.extras?.get("data") as Bitmap?
            findViewById<ImageView>(R.id.imgPreview).setImageBitmap(photo)
        }
    }
}