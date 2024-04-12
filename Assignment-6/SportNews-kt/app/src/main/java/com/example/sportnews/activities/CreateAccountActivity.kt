package com.example.sportnews.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sportnews.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etEmail = binding.etCreateEmail
        val etPassword = binding.etPassword
        val btnCreateAccount = binding.btnCreateAccount
        val tvLogin = binding.tvLogin

        val storage = getSharedPreferences("auth", MODE_PRIVATE)
        val intent = Intent(this, LoginActivity::class.java)

        btnCreateAccount.setOnClickListener {
            val editor = storage.edit()
            editor.putString("email", etEmail.text.toString())
            editor.putString("password", etPassword.text.toString());
            editor.apply();
            startActivity(intent)
        }

        tvLogin.setOnClickListener {
            startActivity(intent)
        }
    }
}