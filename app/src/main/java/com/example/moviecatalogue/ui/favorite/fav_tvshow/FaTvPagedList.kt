package com.example.moviecatalogue.ui.favorite.fav_tvshow

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.databinding.ListItemsTvBinding
import com.example.moviecatalogue.ui.detailmovie.DetailMovieActivity
import com.example.moviecatalogue.ui.detailtvshow.DetailTvActivity

class FaTvPagedList (private val activity: Activity) : PagedListAdapter<TvShow, FaTvPagedList.TvViewHolder>(
    DIFF_CALLBAC) {
    companion object {
        private val DIFF_CALLBAC: DiffUtil.ItemCallback<TvShow> =
            object : DiffUtil.ItemCallback<TvShow>() {
                override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean {
                    return oldItem == newItem
                }

            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemsTvBinding =
            ListItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(itemsTvBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShow = getItem(position) as TvShow
        holder.bind(tvShow)
        holder.itemView.setOnClickListener {
            Intent(activity, DetailTvActivity::class.java).apply {
                putExtra("ID", tvShow.id)
                putExtra("TVSHOW", tvShow)
                activity.startActivity(this)
            }
        }
    }
    inner class TvViewHolder(private val binding: ListItemsTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                tvTitle.text = tvShow.originalname
                tvDesc.text = tvShow.overview
                tvYear.text = tvShow.firstairdate
                tvLanguage.text = tvShow.originallanguage
                tvRating.text = tvShow.voteaverage.toString()
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w154${tvShow.posterpath}")
                    .into(binding.imgPoster)
            }
        }
    }


}