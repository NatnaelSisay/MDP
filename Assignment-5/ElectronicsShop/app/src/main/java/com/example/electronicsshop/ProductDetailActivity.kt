package com.example.electronicsshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.electronicsshop.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvDetailTitle = binding.tvDetailTitle
        val tvDetailDescription = binding.tvDetailDescription
        val tvDetailPrice = binding.tvDetailPrice
        val imgDetailImage = binding.imgDetailImage
        val imgDetailLogo = binding.imgDetailLogo
        val btnBackHome = binding.btnDetailBack

        val product = intent.getSerializableExtra("EXTRA_PRODUCT") as Product

        tvDetailTitle.text = product.name
        tvDetailDescription.text = product.description
        tvDetailPrice.text = product.price.toString()
        imgDetailImage.setImageResource(product.image)
        imgDetailLogo.setImageResource(product.logo)

        btnBackHome.setOnClickListener {
            finish()
        }
    }
}