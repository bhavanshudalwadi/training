// RegistrationFragment.kt
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.q17.databinding.Fragement1Binding


class Fragment1 : Fragment() {

    private var _binding: Fragement1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragement1Binding.inflate(inflater, container, false)
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

        val name = binding.etName.text.toString().trim()
        if (name.isEmpty()) {
            binding.tilName.error = "Name cannot be empty"
            isValid = false
        } else {
            binding.tilName.error = null
        }

        val email = binding.etEmail.text.toString().trim()
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Enter a valid email address"
            isValid = false
        } else {
            binding.tilEmail.error = null
        }


        val phone = binding.etPhone.text.toString().trim()
        if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
            binding.tilPhone.error = "Enter a valid phone number"
            isValid = false
        } else {
            binding.tilPhone.error = null
        }


        return isValid
    }

    private fun submitRegistration() {
        binding.etName.text?.let { it.clear()
        }
        binding.etEmail.text?.let { it.clear() }
        binding.etPhone.text?.let { it.clear() }
        binding.etAddress.text?.let { it.clear() }
        binding.etCity.text?.let { it.clear() }
        binding.etState.text?.let { it.clear() }
        binding.etCountry.text?.let { it.clear() }
        binding.etZip.text?.let { it.clear() }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
