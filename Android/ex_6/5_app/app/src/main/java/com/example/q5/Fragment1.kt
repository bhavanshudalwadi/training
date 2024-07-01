package com.example.q5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.example.q5.databinding.FragmentBinding

class Fragment1 : Fragment() {

    private var _binding: FragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        val textViewLabel = binding.textViewLabel
        val switchToggle = binding.switchToggle
        val imageView = binding.imageView

        switchToggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textViewLabel.text = "ON"
                imageView.setImageResource(R.drawable.on)
            } else {
                textViewLabel.text = "OFF"
                imageView.setImageResource(R.drawable.off)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
