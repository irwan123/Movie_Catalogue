package com.example.moviecatalogue.ui.detailmovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.repository.RepositoryAPI
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val repository : RepositoryAPI,
    private val repositoryDatabase: RepositoryDatabase
) : ViewModel() {
    private val favoriteMovie = MutableLiveData<Boolean>(false)
    val isFavorite get()= favoriteMovie
    private val dataMovie = MutableLiveData<DetailMovie>()
    val movie get() = dataMovie

    fun getMovie(id: Int) {
        viewModelScope.launch(Dispatchers.IO){
            dataMovie.postValue(repository.getMovieDetail(id))
        }
    }
    fun isFavorite(movie: Movie){
        viewModelScope.launch(Dispatchers.IO){
            val hasil: Int? = repositoryDatabase.isFavoriteMovie(movie)
            if (hasil != null){
                isFavorite.postValue(hasil > 0)
            }
        }
    }
    fun addFavorite(movie: Movie){
        viewModelScope.launch(Dispatchers.IO){
            repositoryDatabase.addFavoriteMovie(movie)
        }
    }
    fun deleteFavorite(movie: Movie){
        viewModelScope.launch(Dispatchers.IO){
            repositoryDatabase.deleteFavoriteMovie(movie)
        }
    }
}