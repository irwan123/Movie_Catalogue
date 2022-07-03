package com.example.moviecatalogue.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.ActivityMainBinding
import com.example.moviecatalogue.ui.detailmovie.DetailMovieActivity
import com.example.moviecatalogue.ui.favorite.FavoriteActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(toolbar)
        val sectionPageAdapter =
            SectionPageAdapter(
                this,
                supportFragmentManager
            )
        binding.viewPager.adapter = sectionPageAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var item = item.itemId
        when(item){
            R.id.settings -> Toast.makeText(applicationContext, "Ini Settings", Toast.LENGTH_SHORT).show()
            R.id.fav -> Intent(applicationContext, FavoriteActivity::class.java).apply {
                applicationContext.startActivity(this)
            }
        }
        return false
    }
}


