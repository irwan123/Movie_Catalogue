package com.example.moviecatalogue.ui.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.databinding.FragmentTvBinding
import com.example.moviecatalogue.ui.detailmovie.DetailMovieActivity
import com.example.moviecatalogue.ui.detailtvshow.DetailTvActivity
import com.example.moviecatalogue.ui.movie.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvFragment : Fragment() {
    private lateinit var fragmentTvBinding: FragmentTvBinding
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tv: ArrayList<TvShow>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            viewModel.getTv()
            showLoading(true)
            val tvAdapter =  TvAdapter()
            viewModel.tvList.observe(viewLifecycleOwner){ tvList ->
                if (tvList.isNotEmpty()){
                    tv = tvList as ArrayList<TvShow>
                    tvAdapter.setMovie(ArrayList(tvList))
                    showLoading(false)
                }
            }
            with(fragmentTvBinding.rvTv){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }
        }
    }
    private fun showLoading(boolean: Boolean) {
        if (boolean) {
            fragmentTvBinding.progress.visibility = View.VISIBLE
            fragmentTvBinding.rvTv.visibility = View.GONE
        } else {
            fragmentTvBinding.rvTv.visibility = View.VISIBLE
            fragmentTvBinding.progress.visibility = View.GONE
        }
    }
}