package com.example.q18

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.q18.databinding.Fragment1Binding
import com.google.android.material.textfield.TextInputLayout


class Fragment1 : Fragment() {

    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater, container, false)
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
        return if (zip.isEmpty()) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

    private fun submitRegistration() {
        binding.etName.text.apply { this?.clear() }
        binding.etEmail.text.apply { this?.clear() }
        binding.etAddress.text.apply { this?.clear() }
        binding.etCity.text.apply { this?.clear() }
        binding.etPhone.text.apply { this?.clear() }
        binding.etZip.text.apply { this?.clear() }
        binding.etCountry.text.apply { this?.clear() }
        binding.etState.text.apply { this?.clear() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
