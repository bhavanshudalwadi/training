package com.example.q19

import Login
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.q19.databinding.RegisterBinding
import com.google.android.material.textfield.TextInputLayout


class Register : Fragment() {

    private var _binding: RegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSubmit.setOnClickListener {
            if (isValidInput()) {
                submitRegistration()
            }
        }

        return view
    }

    private fun isValidInput(): Boolean {
        var isValid = true
        isValid = validateField(binding.tilName, "Name cannot be empty") && isValid
        isValid = validateEmailField(binding.tilEmail, "Enter a valid email address") && isValid
        isValid = validatePhoneField(binding.tilPhone, "Enter a valid phone number") && isValid
        isValid = validateField(binding.tilAddress, "Address cannot be empty") && isValid
        isValid = validateField(binding.tilCity, "City cannot be empty") && isValid
        isValid = validateField(binding.tilState, "State cannot be empty") && isValid
        isValid = validateField(binding.tilCountry, "Country cannot be empty") && isValid
        isValid = validateZipField(binding.tilZip, "Enter a valid zip code") && isValid
        return isValid
    }

    private fun validateField(textInputLayout: TextInputLayout, errorMessage: String): Boolean {
        val text = textInputLayout.editText?.text.toString().trim()
        return if (text.isEmpty()) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

    private fun validateEmailField(textInputLayout: TextInputLayout, errorMessage: String): Boolean {
        val email = textInputLayout.editText?.text.toString().trim()
        return if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

    private fun validatePhoneField(textInputLayout: TextInputLayout, errorMessage: String): Boolean {
        val phone = textInputLayout.editText?.text.toString().trim()
        return if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

    private fun validateZipField(textInputLayout: TextInputLayout, errorMessage: String): Boolean {
        val zip = textInputLayout.editText?.text.toString().trim()
        return if (zip.isEmpty() ) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

    private fun submitRegistration() {
        Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
