package com.example.q19

import Login
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.q19.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginFragment = Login()
        val registerFragment = Register()

        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, registerFragment).commit()

        binding.btnLogin.setOnClickListener {
            replaceFragment(loginFragment)
        }

        binding.btnRegister.setOnClickListener {
            replaceFragment(registerFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}
