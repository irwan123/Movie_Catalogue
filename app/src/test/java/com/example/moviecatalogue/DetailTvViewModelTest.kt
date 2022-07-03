package com.example.moviecatalogue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.model.DetaiTvShow
import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.model.TvShow
import com.example.moviecatalogue.data.repository.RepositoryAPI
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import com.example.moviecatalogue.ui.detailmovie.DetailMovieViewModel
import com.example.moviecatalogue.ui.detailtvshow.DetailTvViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailTvViewModelTest {
    private lateinit var detailTvModel: DetailTvViewModel
    private lateinit var sampleDataTv: TvShow
    // Rule
    @get:Rule
    var instantRule = InstantTaskExecutorRule()
    @get:Rule
    var coroutineRule = CoroutineRule()
    // Mock
    @Mock
    private lateinit var repositoryAPI: RepositoryAPI
    @Mock
    private lateinit var repositoryDatabase: RepositoryDatabase
    @Mock
    private lateinit var observer: Observer<DetaiTvShow>
    @Mock
    private lateinit var observerFav: Observer<Boolean>
    // Setup Id
    @Before
    fun setUp() {
        sampleDataTv = TvShow(
            1,
            "Title_Tv",
            "6-07-2021",
            "Language_Tv",
            8.2,
            "Overview_Tv",
            "PosterPath_Tv",
        )
        detailTvModel = DetailTvViewModel(repositoryAPI, repositoryDatabase)
        detailTvModel.getTv(88396)
    }
    // Testing
    @Test
    fun getData() {
        runBlocking {
            detailTvModel.tv.observeForever(observer)
            val tvShow = detailTvModel.tv.value
            Mockito.verify(repositoryAPI).getTvshowDetail(88396)
            Mockito.verify(observer).onChanged(tvShow)
        }
    }
    @Test
    fun addFav() = runBlocking{
        detailTvModel.addFavorite(sampleDataTv)
        detailTvModel.isFavorite(sampleDataTv)
        detailTvModel.isFavorite.observeForever(observerFav)
        val value = detailTvModel.isFavorite.value
        Mockito.verify(repositoryDatabase).addFavoriteTv(sampleDataTv)
        Mockito.verify(repositoryDatabase).isFavoriteTv(sampleDataTv)
        Mockito.verify(observerFav).onChanged(value)
    }
    @Test
    fun deleteFav() = runBlocking{
        detailTvModel.addFavorite(sampleDataTv)
        detailTvModel.deleteFavorite(sampleDataTv)
        detailTvModel.isFavorite(sampleDataTv)
        detailTvModel.isFavorite.observeForever(observerFav)
        val value = detailTvModel.isFavorite.value
        Mockito.verify(repositoryDatabase).addFavoriteTv(sampleDataTv)
        Mockito.verify(repositoryDatabase).deleteFavoriteTv(sampleDataTv)
        Mockito.verify(repositoryDatabase).isFavoriteTv(sampleDataTv)
        Mockito.verify(observerFav).onChanged(value)
    }
}