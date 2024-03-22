package com.example.ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ecommerce.databinding.ActivityShoppingCategoryBinding

class ShoppingCategory : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}