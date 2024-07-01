package com.example.eleven_app
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMobile: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var editTextLayoutMobile: TextInputLayout
    private lateinit var editTextLayoutEmail: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMobile = findViewById(R.id.editText)
        editTextEmail = findViewById(R.id.editText1)
        buttonSubmit = findViewById(R.id.button)
        editTextLayoutMobile = findViewById(R.id.editText_layout)
        editTextLayoutEmail = findViewById(R.id.editText_layout2)

        buttonSubmit.setOnClickListener {
            validateAndProcessData()
        }
    }

    private fun validateAndProcessData() {
        val email = editTextEmail.text.toString().trim()
        val mobile = editTextMobile.text.toString().trim()

        if (mobile.isEmpty() || !isValidMobile(mobile)) {
            editTextLayoutMobile.error = "Invalid mobile number"
            return
        } else {
            editTextLayoutMobile.error = null
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextLayoutEmail.error = "Invalid email"
            return
        } else {
            editTextLayoutEmail.error = null
        }

        // If both email and mobile are valid, print information and clear data
        Toast.makeText(this, "Valid email: $email\nValid mobile: $mobile", Toast.LENGTH_SHORT).show()
        clearData()
    }

    private fun isValidMobile(mobile: String): Boolean {
        // Simple validation for mobile number
        return mobile.length == 10 && mobile.matches(Regex("\\d+"))
    }

    private fun clearData() {
        editTextMobile.text.clear()
        editTextEmail.text.clear()
    }
}
