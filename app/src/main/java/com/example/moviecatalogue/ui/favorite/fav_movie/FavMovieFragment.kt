package com.example.moviecatalogue.ui.favorite.fav_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.databinding.FragmentFavMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavMovieFragment: Fragment() {
    private lateinit var binding: FragmentFavMovieBinding
    private lateinit var moviePagedList: FavMoviePagedList
    private val viewModel: FavMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviePagedList = FavMoviePagedList(requireActivity())
        viewModel.getFavMovie().observe(viewLifecycleOwner){ movieListPage ->
            if (movieListPage != null){
                moviePagedList.submitList(movieListPage)
            }
        }
        binding.rvMovie.apply {
            adapter = moviePagedList
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
    }
}