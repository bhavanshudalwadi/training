package com.example.a18_app

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

import com.example.a18_app.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var url = "https://d1vwxdpzbgdqj.cloudfront.net/aiml-lp-new/aiml-mccomb-v31.jpg"
        Picasso.get()
            .load(url)
            .into(binding.urlImg)

        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = OneFragment()




        binding.notificationIcon.setOnClickListener {
            val mBundle = Bundle()
            mFragmentTransaction.replace(R.id.frameLayout, mFragment)
            mFragmentTransaction.commit()

        }

    }
}