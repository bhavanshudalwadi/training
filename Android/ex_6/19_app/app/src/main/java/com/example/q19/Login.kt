import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import com.example.q19.databinding.LoginBinding
import com.google.android.material.textfield.TextInputLayout

class Login : Fragment() {

    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnLogin.setOnClickListener {
            if (isValidInput()) {
                loginUser()
            }
        }

        return view
    }

    private fun isValidInput(): Boolean {
        var isValid = true
        isValid = validateEmailField(binding.tilEmail, "Enter a valid email address") && isValid
        isValid = validatePasswordField(binding.tilPassword, "Password cannot be empty") && isValid

        return isValid
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

    private fun validatePasswordField(textInputLayout: TextInputLayout, errorMessage: String): Boolean {
        val password = textInputLayout.editText?.text.toString().trim()
        return if (password.isEmpty()) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

    private fun loginUser() {
        Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
