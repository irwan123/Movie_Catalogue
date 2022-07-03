package com.example.moviecatalogue.ui.favorite.fav_movie

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.databinding.ListItemsMovieBinding
import com.example.moviecatalogue.ui.detailmovie.DetailMovieActivity
import com.example.moviecatalogue.ui.movie.MovieAdapter

class FavMoviePagedList(private val activity: Activity) : PagedListAdapter<Movie, FavMoviePagedList.MoviewViewHolder>(
    DIFF_CALLBAC) {
    companion object {
        private val DIFF_CALLBAC: DiffUtil.ItemCallback<Movie> =
            object : DiffUtil.ItemCallback<Movie>() {
                override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem == newItem
                }

            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        val itemsMovieBinding =
            ListItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviewViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        val movie = getItem(position) as Movie
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            Intent(activity, DetailMovieActivity::class.java).apply {
                putExtra("ID", movie.id)
                putExtra("MOVIE", movie)
                activity.startActivity(this)
            }
        }
    }
    inner class MoviewViewHolder(private val binding: ListItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvTitle.text = movie.originaltitle
                tvDesc.text = movie.overview
                tvYear.text = movie.releasedate
                tvLanguage.text = movie.originallanguage
                tvRating.text = movie.voteaverage.toString()
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w154${movie.posterpath}")
                    .into(binding.imgPoster)
            }
        }
    }
}