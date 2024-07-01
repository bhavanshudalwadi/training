package com.example.`1_app`

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.`1_app`.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private lateinit var binding : Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onStart() {
        super.onStart()
        showToastAndLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        showToastAndLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        showToastAndLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        showToastAndLog("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showToastAndLog("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToastAndLog("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        showToastAndLog("onDetach")
    }

    private fun showToastAndLog(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        Log.d("tag", message)
    }
}
