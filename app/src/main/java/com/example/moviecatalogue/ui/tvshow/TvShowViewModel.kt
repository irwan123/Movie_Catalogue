package com.example.moviecatalogue.ui.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.TvShowData
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.repository.RepositoryAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val repository: RepositoryAPI
) : ViewModel(){
    private val listTv = MutableLiveData<List<TvShow>>()
    val tvList get() = listTv
    fun getTv() {
        viewModelScope.launch(Dispatchers.IO) {
            listTv.postValue(repository.getPopularTvshow())
        }
    }
}