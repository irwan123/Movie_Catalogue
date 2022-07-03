package com.example.moviecatalogue.ui.detailtvshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.databinding.ActivityDetailTvBinding
import com.example.moviecatalogue.databinding.DetaiContentTvBinding
import com.example.moviecatalogue.ui.MainActivity
import com.example.moviecatalogue.ui.detailmovie.DetailMovieViewModel
import com.example.moviecatalogue.ui.movie.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.detai_content_tv.toolbar
@AndroidEntryPoint
class DetailTvActivity : AppCompatActivity() {
    private lateinit var detaiContentTvBinding: DetaiContentTvBinding
    private val viewModel: DetailTvViewModel by viewModels()
    private lateinit var tvShow: TvShow
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvBinding = ActivityDetailTvBinding.inflate(layoutInflater)
        detaiContentTvBinding = activityDetailTvBinding.detailContenttv
        setContentView(activityDetailTvBinding.root)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val id = intent.getIntExtra("ID", 0)
        tvShow = intent.getParcelableExtra<TvShow>("TVSHOW") as TvShow
        viewModel.getTv(id)
        viewModel.isFavorite(tvShow)
        showLoading(true)

        viewModel.tv.observe(this) { dtv ->
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w154${dtv.posterpath}")
                .into(detaiContentTvBinding.imgPoster)
            detaiContentTvBinding.tvTitle.text = dtv.originaltitle
            detaiContentTvBinding.tvYear.text = dtv.firstairdate
            detaiContentTvBinding.tvDuration.text = dtv.popularity.toString()
            detaiContentTvBinding.tvRating.text = dtv.voteaverage.toString()
            detaiContentTvBinding.tvLanguage.text = dtv.originallanguage
            detaiContentTvBinding.tvDesc.text = dtv.overview
            showLoading(false)
        }

        viewModel.isFavorite.observe(this){state ->
            detaiContentTvBinding.favTv.isChecked = state
        }

        detaiContentTvBinding.favTv.setOnClickListener {
            if (detaiContentTvBinding.favTv.isChecked){
                viewModel.addFavorite(tvShow)
            } else {
                viewModel.deleteFavorite(tvShow)
            }
        }
    }
    private fun showLoading(boolean: Boolean) {
        if (boolean) {
            detaiContentTvBinding.tvLanguage.visibility = View.GONE
            detaiContentTvBinding.imgPoster.visibility = View.GONE
            detaiContentTvBinding.tvDesc.visibility = View.GONE
            detaiContentTvBinding.tvDuration.visibility = View.GONE
            detaiContentTvBinding.tvRating.visibility = View.GONE
            detaiContentTvBinding.tvTitle.visibility = View.GONE
            detaiContentTvBinding.tvYear.visibility = View.GONE
            detaiContentTvBinding.linearLayout.visibility = View.GONE
            detaiContentTvBinding.linearLayout2.visibility = View.GONE
            detaiContentTvBinding.toolbar.visibility = View.GONE

            detaiContentTvBinding.progress.visibility = View.VISIBLE
        } else {
            detaiContentTvBinding.tvLanguage.visibility = View.VISIBLE
            detaiContentTvBinding.imgPoster.visibility = View.VISIBLE
            detaiContentTvBinding.tvDesc.visibility = View.VISIBLE
            detaiContentTvBinding.tvDuration.visibility = View.VISIBLE
            detaiContentTvBinding.tvRating.visibility = View.VISIBLE
            detaiContentTvBinding.tvTitle.visibility = View.VISIBLE
            detaiContentTvBinding.tvYear.visibility = View.VISIBLE
            detaiContentTvBinding.linearLayout.visibility = View.VISIBLE
            detaiContentTvBinding.linearLayout2.visibility = View.VISIBLE
            detaiContentTvBinding.toolbar.visibility = View.VISIBLE

            detaiContentTvBinding.progress.visibility = View.GONE
        }
    }
}


