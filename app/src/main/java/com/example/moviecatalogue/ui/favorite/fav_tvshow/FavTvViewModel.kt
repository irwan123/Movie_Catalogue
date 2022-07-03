package com.example.moviecatalogue.ui.favorite.fav_tvshow

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavTvViewModel @Inject constructor(
    private val repositoryDatabase: RepositoryDatabase
): ViewModel() {
    fun getFavTv() = LivePagedListBuilder(
        repositoryDatabase.getFavoriteTvShow(),
        20,
    ).build()
}