package com.example.sportnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sportnews.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etLoginEmail = binding.etLoginEmail
        val etLoginPass = binding.etLoginPassword
        val btnLogin = binding.btnLogin
        val tvCreateAccount = binding.tvCreateAccount

        val intentCreateAccount = Intent(this, CreateAccountActivity::class.java)
        val intentMain = Intent(this, MainActivity::class.java)

        val editor = getSharedPreferences("auth", MODE_PRIVATE)
        val email = editor.getString("email", "")
        val password = editor.getString("password", "")

        btnLogin.setOnClickListener {
            if(
                etLoginEmail.text.toString() == email &&
                etLoginPass.text.toString() == password
            ){
                val storage = getSharedPreferences("auth", MODE_PRIVATE)
                val editStorage = storage.edit()
                editStorage.putBoolean("loggedIn", true)
                editStorage.apply()

                finishAffinity()
                startActivity(intentMain)
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }

        tvCreateAccount.setOnClickListener {
            startActivity(intentCreateAccount)
        }

    }
}