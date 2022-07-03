package com.example.moviecatalogue.ui.detailtvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.TvShowData
import com.example.moviecatalogue.data.model.DetaiTvShow
import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.repository.RepositoryAPI
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailTvViewModel @Inject constructor(
    private val repository : RepositoryAPI,
    private val repositoryDatabase: RepositoryDatabase
) : ViewModel() {
    private val favoriteTv = MutableLiveData<Boolean>(false)
    val isFavorite get()= favoriteTv
    private val dataTv = MutableLiveData<DetaiTvShow>()
    val tv get() = dataTv

    fun getTv(id: Int) {
        viewModelScope.launch(Dispatchers.IO){
            dataTv.postValue(repository.getTvshowDetail(id))
        }
    }
    fun isFavorite(tvShow: TvShow){
        viewModelScope.launch(Dispatchers.IO){
            val hasil: Int? = repositoryDatabase.isFavoriteTv(tvShow)
            if (hasil != null){
                isFavorite.postValue(hasil > 0)
            }
        }
    }
    fun addFavorite(tvShow: TvShow){
        viewModelScope.launch(Dispatchers.IO){
            repositoryDatabase.addFavoriteTv(tvShow)
        }
    }
    fun deleteFavorite(tvShow: TvShow){
        viewModelScope.launch(Dispatchers.IO){
            repositoryDatabase.deleteFavoriteTv(tvShow)
        }
    }
}