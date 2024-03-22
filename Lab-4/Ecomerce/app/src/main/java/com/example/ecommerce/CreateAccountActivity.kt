package com.example.ecommerce

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonToken
import android.widget.Toast
import com.example.ecommerce.databinding.ActivityCreateAccountBinding
import com.google.gson.Gson
import org.json.JSONStringer

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storage = getSharedPreferences("AUTH", Context.MODE_PRIVATE)

        // UI
        val etFullName = binding.etFullName
        val etEmailAddress = binding.etEmailAddress
        val etPasswordMain = binding.etPasswordMain
        val etPasswordConfirm = binding.etPasswordConfirm
        //
        val btnContinue = binding.btnContinue

        btnContinue.setOnClickListener {
            val fullName = etFullName.text.toString()
            val email = etEmailAddress.text.toString()
            val password = etPasswordMain.text.toString()
            val confirmPassword = etPasswordConfirm.text.toString()

            if(fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "Fields can't be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(password != confirmPassword){
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(storage.getString(email, "") != ""){
                Toast.makeText(this, "Email Already exist", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newUser = User(fullName, email, password)
            val json = Gson().toJson(newUser)

            val editor = storage.edit()
            editor.putString(email, json)
            editor.apply()
        }
    }
}