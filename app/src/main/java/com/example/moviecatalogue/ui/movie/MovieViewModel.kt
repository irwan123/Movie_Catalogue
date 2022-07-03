package com.example.moviecatalogue.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.repository.RepositoryAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import  kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: RepositoryAPI
) : ViewModel() {
    private val listMovie = MutableLiveData<List<Movie>>()
    val movieList get() = listMovie
    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            listMovie.postValue(repository.getUpComingMovies())
        }
    }
}
