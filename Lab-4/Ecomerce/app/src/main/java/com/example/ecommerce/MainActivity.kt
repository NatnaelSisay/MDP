package com.example.ecommerce

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ecommerce.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.JsonParser

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storage = getSharedPreferences("AUTH", Context.MODE_PRIVATE)

        // UI-elements
        val etEmail = binding.etEmail
        val etPassword = binding.etPassword
        //
        val cbShowPassword = binding.cbShowPassword
        //
        val btnSignIn = binding.btnSignIn
        val btnCreateAccount = binding.btnCreateAccount

        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString();

            if(storage.getString(email, "") != ""){
                val user = Gson().fromJson<User>(storage.getString(email, ""), User::class.java)
                if(user.password == password){
                    Intent(this, ShoppingCategory::class.java).apply {
                        startActivity(this)
                    }
                } else {
                    Toast.makeText(this, "Error, check email or password", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Error, check email or password", Toast.LENGTH_LONG).show()
            }
        }

        btnCreateAccount.setOnClickListener {
            Intent(this, CreateAccountActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}