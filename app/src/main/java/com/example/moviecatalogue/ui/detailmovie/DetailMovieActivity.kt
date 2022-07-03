package com.example.moviecatalogue.ui.detailmovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import androidx.activity.viewModels
import com.example.moviecatalogue.data.model.Movie

import com.example.moviecatalogue.databinding.ActivityDetailBinding
import com.example.moviecatalogue.databinding.DetailContentBinding
import com.example.moviecatalogue.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.detail_content.*
@AndroidEntryPoint
class DetailMovieActivity : AppCompatActivity() {
    private lateinit var detailContentBinding: DetailContentBinding
    private val viewModel: DetailMovieViewModel by viewModels()
    private lateinit var movie: Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailBinding.detailContent
        setContentView(activityDetailBinding.root)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val id = intent.getIntExtra("ID", 0)
        movie = intent.getParcelableExtra<Movie>("MOVIE") as Movie
        viewModel.getMovie(id)
        viewModel.isFavorite(movie)
        showLoading(true)

        viewModel.movie.observe(this) { dmovie ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w154${dmovie.posterpath}")
                .into(detailContentBinding.imgPoster)
            detailContentBinding.tvTitle.text = dmovie.originaltitle
            detailContentBinding.tvYear.text = dmovie.releasedate
            detailContentBinding.tvDuration.text = dmovie.popularity.toString()
            detailContentBinding.tvRating.text = dmovie.voteaverage.toString()
            detailContentBinding.tvLanguage.text = dmovie.originallanguage
            detailContentBinding.tvDesc.text = dmovie.overview
            showLoading(false)
        }

        viewModel.isFavorite.observe(this){state ->
            detailContentBinding.favMovie.isChecked = state
        }

        detailContentBinding.favMovie.setOnClickListener {
            if (detailContentBinding.favMovie.isChecked){
                viewModel.addFavorite(movie)
            } else {
                viewModel.deleteFavorite(movie)
            }
        }
    }
        private fun showLoading(boolean: Boolean) {
            if (boolean) {
                detailContentBinding.tvLanguage.visibility = View.GONE
                detailContentBinding.imgPoster.visibility = View.GONE
                detailContentBinding.tvDesc.visibility = View.GONE
                detailContentBinding.tvDuration.visibility = View.GONE
                detailContentBinding.tvRating.visibility = View.GONE
                detailContentBinding.tvTitle.visibility = View.GONE
                detailContentBinding.tvYear.visibility = View.GONE
                detailContentBinding.linearLayout.visibility = View.GONE
                detailContentBinding.linearLayout2.visibility = View.GONE
                detailContentBinding.toolbar.visibility = View.GONE

                detailContentBinding.progress.visibility = View.VISIBLE
            } else {
                detailContentBinding.tvLanguage.visibility = View.VISIBLE
                detailContentBinding.imgPoster.visibility = View.VISIBLE
                detailContentBinding.tvDesc.visibility = View.VISIBLE
                detailContentBinding.tvDuration.visibility = View.VISIBLE
                detailContentBinding.tvRating.visibility = View.VISIBLE
                detailContentBinding.tvTitle.visibility = View.VISIBLE
                detailContentBinding.tvYear.visibility = View.VISIBLE
                detailContentBinding.linearLayout.visibility = View.VISIBLE
                detailContentBinding.linearLayout2.visibility = View.VISIBLE
                detailContentBinding.toolbar.visibility = View.VISIBLE

                detailContentBinding.progress.visibility = View.GONE
            }
        }
    }

