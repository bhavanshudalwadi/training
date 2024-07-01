package com.example.q25toq43.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.q25toq43.Adapter.TabLayoutAdapter_29
import com.example.q25toq43.R
import com.example.q25toq43.databinding.ActivityQ29Binding
import com.google.android.material.tabs.TabLayout

class q29 : AppCompatActivity() {
    private lateinit var binding: ActivityQ29Binding
    lateinit var adapter29: TabLayoutAdapter_29

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQ29Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tablayout
        val viewPager = binding.viewPager

        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab4"));
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL;

        adapter29 = TabLayoutAdapter_29( supportFragmentManager,lifecycle)
        viewPager.adapter = adapter29



        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }
}