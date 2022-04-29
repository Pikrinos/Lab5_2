package com.example.lab52

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab52.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pager.adapter = Adapter(this)
        TabLayoutMediator(binding.tabLayout, binding.pager){ tab, position ->
            tab.text = "Tab $position"
        }.attach()
    }

    class Adapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){

        private val fragmentFirst = FragmentFirst()
        private val fragmentSecond = FragmentSecond()
        private val fragmentThird = FragmentThird()

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            when(position){
                1 -> return fragmentSecond
                2 -> return fragmentThird
                else -> return fragmentFirst
            }
        }

    }
}