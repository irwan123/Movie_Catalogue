package com.example.moviecatalogue.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.ActivityFavoriteBinding
import com.example.moviecatalogue.ui.SectionPageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val favSectionPageAdapter =
            FavSectionPageAdapter(
                this,
                supportFragmentManager
            )
        binding.viewPager.adapter = favSectionPageAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }
}