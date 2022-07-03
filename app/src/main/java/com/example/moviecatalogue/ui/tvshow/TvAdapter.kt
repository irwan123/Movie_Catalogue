package com.example.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.ui.detailtvshow.DetailTvActivity
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.databinding.ListItemsTvBinding

class TvAdapter: RecyclerView.Adapter<TvAdapter.TvViewHolder>() {

    private var listTv = ArrayList<TvShow>()
    fun setMovie(tvShow: ArrayList<TvShow>?) {
        if (tvShow == null) return
        this.listTv.clear()
        this.listTv.addAll(tvShow)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val itemsTvBinding =
            ListItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(
            itemsTvBinding
        )
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShow = listTv[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTv.size

    class TvViewHolder(private val binding: ListItemsTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {
                tvTitle.text = tvShow.originalname
                tvDesc.text = tvShow.overview
                tvYear.text = tvShow.firstairdate
                tvLanguage.text = tvShow.originallanguage
                tvRating.text = tvShow.voteaverage.toString()
                itemView.setOnClickListener {
                    Intent(itemView.context, DetailTvActivity::class.java).apply {
                        putExtra("ID", tvShow.id)
                        putExtra("TVSHOW", tvShow)
                        itemView.context.startActivity(this)
                    }
                }
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w154${tvShow.posterpath}")
                    .into(binding.imgPoster)
            }
        }
    }
}

