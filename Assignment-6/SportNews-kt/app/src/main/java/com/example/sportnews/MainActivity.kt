package com.example.sportnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sportnews.activities.CreateAccountActivity
import com.example.sportnews.activities.LoginActivity
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
        val editor = getSharedPreferences("auth", MODE_PRIVATE)
        val email = editor.getString("email", "")
        val isLoggedIn = editor.getBoolean("loggedIn", false)

        if(email!!.isEmpty()){
            startActivity(Intent(this, CreateAccountActivity::class.java))
        } else {
            if(!isLoggedIn) {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
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