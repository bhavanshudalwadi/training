package com.example.q4

// InputFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentHostCallback
import com.example.q4.databinding.Fragment1Binding


class InputFragment : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root

        val editTextTitle = binding.editTextTitle
        val btnChangeTitle = binding.btnChangeTitle

        btnChangeTitle.setOnClickListener {
            val newTitle = editTextTitle.text.toString().trim()
            if (newTitle.isNotEmpty()) {
                requireActivity().title = newTitle
                binding.tv.text= newTitle
            } else {
                editTextTitle.error = "Title cannot be empty"
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
