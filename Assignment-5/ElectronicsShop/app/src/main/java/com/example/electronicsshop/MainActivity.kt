package com.example.electronicsshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        rvMainRecycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvMainRecycler.adapter = ProductAdapter(this, productList)
    }
}