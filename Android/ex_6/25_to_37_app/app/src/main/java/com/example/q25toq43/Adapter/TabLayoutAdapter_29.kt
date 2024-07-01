package com.example.q25toq43.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.q25toq43.Fragments.Fragment_1_29
import com.example.q25toq43.Fragments.Fragment_2_29
import com.example.q25toq43.Fragments.Fragment_3_29
import com.example.q25toq43.Fragments.Fragment_4_29

class TabLayoutAdapter_29( fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm,lifecycle) {


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Fragment_1_29()
            1 -> return Fragment_2_29()
            2 -> return Fragment_3_29()
            3-> return Fragment_4_29()
            else -> return throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
