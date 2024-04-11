package com.example.sportnews.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sportnews.fragments.AboutMeFragment
import com.example.sportnews.fragments.AthletsFragment
import com.example.sportnews.fragments.EventFragment
import com.example.sportnews.fragments.HistoricArchievesFragment
import com.example.sportnews.fragments.NewsFragment
import com.example.sportnews.fragments.SportsFragment

class MyViewPagerAdapter(private val fs: AppCompatActivity): FragmentStateAdapter(fs) {
    override fun getItemCount() = 6

    override fun createFragment(position: Int): Fragment {
        val fragments = listOf(
            SportsFragment(fs), NewsFragment(fs), AthletsFragment(fs),
            EventFragment(fs),HistoricArchievesFragment(fs), AboutMeFragment()
        )

        if (position >= fragments.size) return Fragment()

        return fragments[position]
    }
}