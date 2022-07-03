package com.example.moviecatalogue.ui.favorite.fav_tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.databinding.FragmentFavTvBinding
import com.example.moviecatalogue.databinding.FragmentTvBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavTvFragment: Fragment() {
    private lateinit var binding: FragmentFavTvBinding
    private lateinit var tvPagedList: FaTvPagedList
    private val viewModel: FavTvViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavTvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvPagedList = FaTvPagedList(requireActivity())
        viewModel.getFavTv().observe(viewLifecycleOwner){tvListPage ->
            if (tvListPage != null){
                tvPagedList.submitList(tvListPage)
            }
        }
        binding.rvTv.apply {
            adapter = tvPagedList
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
    }

}