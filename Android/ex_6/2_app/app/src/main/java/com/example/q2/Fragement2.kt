package com.example.q2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.q2.databinding.Fragment1Binding
import com.example.q2.databinding.Fragment2Binding

class Fragement2 : Fragment() {
    private lateinit var binding : Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnNavigate2.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, Fragment1())
                .addToBackStack("Fragment1")
                .commit()

        }

        return view
    }
}