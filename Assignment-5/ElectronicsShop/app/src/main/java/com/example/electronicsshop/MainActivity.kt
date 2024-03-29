package com.example.electronicsshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.electronicsshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val productList = ArrayList<Product>()
    private val cart = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productList.addAll(
            mutableListOf(
                Product("Ipad", "Ipad pro 11-inch", 400.0, R.drawable.apple, R.drawable.ipad),
                Product("MacBook Pro", "M3 MacBook Pro", 2000.0, R.drawable.apple, R.drawable.mac_book),
                Product("Dell Latitude", "Dell Latitude laptop", 1400.0, R.drawable.dell, R.drawable.dell_laptop),
                Product("MacBook Pro", "M3 MacBook Pro", 2000.0, R.drawable.apple, R.drawable.mac_book),
                Product("Dell Latitude", "Dell Latitude laptop", 1400.0, R.drawable.dell, R.drawable.dell_laptop),
                Product("MacBook Pro", "M3 MacBook Pro", 2000.0, R.drawable.apple, R.drawable.mac_book),
                Product("Dell Latitude", "Dell Latitude laptop", 1400.0, R.drawable.dell, R.drawable.dell_laptop),
                Product("MacBook Pro", "M3 MacBook Pro", 2000.0, R.drawable.apple, R.drawable.mac_book),
                Product("Dell Latitude", "Dell Latitude laptop", 1400.0, R.drawable.dell, R.drawable.dell_laptop),
            )
        )

        val rvMainRecycler = binding.rvMainRecycler
        val btnViewCart = binding.btnViewCart

        rvMainRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvMainRecycler.adapter = ProductAdapter(this, productList, cart)

        btnViewCart.setOnClickListener {
            var message = ""

            if(cart.isEmpty()){
                Toast.makeText(this, "Cart is Empty", Toast.LENGTH_SHORT).show()
            }

            for(product in cart){
                message += "${product.name}\n"
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}