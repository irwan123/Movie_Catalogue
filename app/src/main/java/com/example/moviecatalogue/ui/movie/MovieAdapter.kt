package com.example.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.databinding.ListItemsMovieBinding
import com.example.moviecatalogue.ui.detailmovie.DetailMovieActivity

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MoviewViewHolder>() {

    private var listMoview = ArrayList<Movie>()
    fun setMovie(movie: ArrayList<Movie>?) {
        if (movie == null) return
        this.listMoview.clear()
        this.listMoview.addAll(movie)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviewViewHolder {
        val itemsMovieBinding =
            ListItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviewViewHolder(
            itemsMovieBinding
        )
    }

    override fun onBindViewHolder(holder: MoviewViewHolder, position: Int) {
        val movie = listMoview[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMoview.size

    class MoviewViewHolder(private val binding: ListItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                tvTitle.text = movie.originaltitle
                tvDesc.text = movie.overview
                tvYear.text = movie.releasedate
                tvLanguage.text = movie.originallanguage
                tvRating.text = movie.voteaverage.toString()
                itemView.setOnClickListener {
                    Intent(itemView.context, DetailMovieActivity::class.java).apply {
                        putExtra("ID", movie.id)
                        putExtra("MOVIE", movie)
                        itemView.context.startActivity(this)
                    }
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w154${movie.posterpath}")
                    .into(binding.imgPoster)
            }
        }
    }
}



