package com.example.moviecatalogue.ui.movie

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
import com.example.moviecatalogue.databinding.FragmentMovieBinding
import com.example.moviecatalogue.ui.detailmovie.DetailMovieActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movies: ArrayList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            if (activity != null){
                viewModel.getMovies()
                showLoading(true)
                val movieAdapter = MovieAdapter()
                viewModel.movieList.observe(viewLifecycleOwner){ movieList ->
                    if (movieList.isNotEmpty()){
                        movies = movieList as ArrayList<Movie>
                        movieAdapter.setMovie(ArrayList(movieList))
                        showLoading(false)
                    }
                }
                with(fragmentMovieBinding.rvMovie){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = movieAdapter
                }
            }
    }
    private fun showLoading(boolean: Boolean) {
        if (boolean) {
            fragmentMovieBinding.progress.visibility = View.VISIBLE
            fragmentMovieBinding.rvMovie.visibility = View.GONE
        } else {
            fragmentMovieBinding.rvMovie.visibility = View.VISIBLE
            fragmentMovieBinding.progress.visibility = View.GONE
        }
    }
}


