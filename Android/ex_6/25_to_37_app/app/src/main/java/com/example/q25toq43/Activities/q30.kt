package com.example.q25toq43.Activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.q25toq43.Adapter.TabLayoutAdapter_29
import com.example.q25toq43.R
import com.example.q25toq43.databinding.ActivityQ29Binding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class q30 : AppCompatActivity() {
    private lateinit var binding: ActivityQ29Binding
    lateinit var adapter29: TabLayoutAdapter_29

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQ29Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = binding.tablayout
        val viewPager = binding.viewPager

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL;

        adapter29 = TabLayoutAdapter_29( supportFragmentManager,lifecycle)
        viewPager.adapter = adapter29

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Inflate the custom view for the tab
            val customTabView = layoutInflater.inflate(R.layout.custom_tab_layout_30, null)
            // Find views inside the custom view
            val tabIcon = customTabView.findViewById<ImageView>(R.id.tabIcon)
            val tabText = customTabView.findViewById<TextView>(R.id.tabText)
            // Set icon and text for each tab
            when (position) {
                0 -> {
                    tabIcon.setImageResource(R.drawable.ic_1)
                    tabText.text = "Tab 1"
                }
                1 -> {
                    tabIcon.setImageResource(R.drawable.ic_2)
                    tabText.text = "Tab 2"
                }
                2 -> {
                    tabIcon.setImageResource(R.drawable.ic_3)
                    tabText.text = "Tab 3"
                }
                3 -> {
                    tabIcon.setImageResource(R.drawable.ic_4)
                    tabText.text = "Tab 4"
                }
            }
            // Set the custom view for the tab
            tab.customView = customTabView
        }.attach()





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