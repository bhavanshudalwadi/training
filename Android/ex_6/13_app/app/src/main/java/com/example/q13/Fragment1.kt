package com.example.q13

// ExampleFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.q13.databinding.Fragment1Binding


class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.backgroundSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                view.setBackgroundColor(resources.getColor(android.R.color.white))
            } else {
                view.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
