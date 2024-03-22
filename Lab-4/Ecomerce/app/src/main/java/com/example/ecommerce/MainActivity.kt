package com.example.ecommerce

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ecommerce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storage = getSharedPreferences("AUTH", Context.MODE_PRIVATE)

//        UI-elements
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
                val pass = storage.getString(email, "")
                if(pass == password){
                    Toast.makeText(this, "Successfull signup", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Not, Successfull signup", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Not, Successfull signup", Toast.LENGTH_LONG).show()
            }

            Intent(this, CreateAccountActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnCreateAccount.setOnClickListener {
            // Move user to CreateAccountActivity
        }

    }
}