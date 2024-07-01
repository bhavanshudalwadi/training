package com.example.q25toq43.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.q25toq43.Adapter.TabLayoutAdapter_31
import com.example.q25toq43.R
import com.example.q25toq43.databinding.ActivityQ31Binding

private lateinit var binding : ActivityQ31Binding

class q31 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQ31Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val bottomNavigationView = binding.bottomNavView
        val viewPager = binding.viewPager

        val adapter = TabLayoutAdapter_31(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_page1 -> viewPager.currentItem = 0
                R.id.navigation_page2 -> viewPager.currentItem = 1
                R.id.navigation_page3 -> viewPager.currentItem = 2
                R.id.navigation_page4 -> viewPager.currentItem = 3
            }
            true
        }


    }
}