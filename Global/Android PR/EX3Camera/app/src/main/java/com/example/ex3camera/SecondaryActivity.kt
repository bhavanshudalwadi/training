package com.example.ex3camera

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondaryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        findViewById<TextView>(R.id.txtResult).setText(intent.extras?.getString("Content"))

        findViewById<Button>(R.id.btnValidate).setOnClickListener {
            var email = findViewById<EditText>(R.id.editEmail).text
            var phone = findViewById<EditText>(R.id.editPhone).text

            if((!TextUtils.isEmpty(email)) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email is Invalid", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Email is Valid", Toast.LENGTH_LONG).show()
            }

            if((!TextUtils.isEmpty(phone)) && Patterns.PHONE.matcher(phone).matches()) {
                Toast.makeText(this, "Phone is Invalid", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Phone is Valid", Toast.LENGTH_LONG).show()
            }
        }
    }

}