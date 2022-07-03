package com.example.moviecatalogue.ui.favorite.fav_movie

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavMovieViewModel @Inject constructor(
    private val repositoryDatabase: RepositoryDatabase
): ViewModel() {
    fun getFavMovie()= LivePagedListBuilder(
        repositoryDatabase.getFavoriteMovie(),
        20,
    ).build()
}