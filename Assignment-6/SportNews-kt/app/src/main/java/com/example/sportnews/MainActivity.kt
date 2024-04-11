package com.example.sportnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sportnews.adapter.MyViewPagerAdapter
import com.example.sportnews.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout.GRAVITY_FILL
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val tabs = listOf<String>("Sports", "News", "Athletes", "Events", "Historical Archives", "About Me")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
        val tabLayout = binding.tabLayout
        val view = binding.pageView
        val bottomNav = binding.bottomNav;
//
        tabLayout.tabGravity = GRAVITY_FILL
//
        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottomNavNews -> view.currentItem = 1
                R.id.bottomNavEvent -> view.currentItem = 3
                R.id.bottomNavHistory -> view.currentItem = 4
                else -> {print("unknown")}
            }
            true
        }
//
        view.adapter = MyViewPagerAdapter(this)
//
        TabLayoutMediator(tabLayout, view){
            tab, position -> run {
                tab.text = tabs[position]
            }
        }.attach()
    }

    private fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}