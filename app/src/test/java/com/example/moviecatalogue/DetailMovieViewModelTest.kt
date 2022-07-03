package com.example.moviecatalogue

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.model.DetailMovie
import com.example.moviecatalogue.data.model.Movie
import com.example.moviecatalogue.data.repository.RepositoryAPI
import com.example.moviecatalogue.data.repository.RepositoryDatabase
import com.example.moviecatalogue.ui.detailmovie.DetailMovieViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest{
    private lateinit var detailMovieModel: DetailMovieViewModel
    private lateinit var sampleDataMovie: Movie
    // Rule
    @get:Rule
    var instantRule = InstantTaskExecutorRule()
    // Mock
    @Mock
    private lateinit var repositoryAPI: RepositoryAPI
    @Mock
    private lateinit var repositoryDatabase: RepositoryDatabase
    @Mock
    private lateinit var observer: Observer<DetailMovie>
    @Mock
    private lateinit var observerFav: Observer<Boolean>
    // Setup Id
    @Before
    fun setUp(){
        sampleDataMovie = Movie(
            1,
            "Title_Movie",
            "Language_Movie",
            "6-07-2021",
            8.2,
            "Overview_Movie",
            "PosterPath_Movie",
        )
        detailMovieModel = DetailMovieViewModel(repositoryAPI, repositoryDatabase)
        detailMovieModel.getMovie(460465)
    }
    // Testing
    @Test
    fun getData(){
        runBlocking {
            detailMovieModel.movie.observeForever(observer)
            val movie = detailMovieModel.movie.value
            verify(repositoryAPI).getMovieDetail(460465)
            verify(observer).onChanged(movie)
        }
    }
    @Test
    fun addFav() = runBlocking{
        detailMovieModel.addFavorite(sampleDataMovie)
        detailMovieModel.isFavorite(sampleDataMovie)
        detailMovieModel.isFavorite.observeForever(observerFav)
        val value = detailMovieModel.isFavorite.value
        verify(repositoryDatabase).addFavoriteMovie(sampleDataMovie)
        verify(repositoryDatabase).isFavoriteMovie(sampleDataMovie)
        verify(observerFav).onChanged(value)
    }
    @Test
    fun deleteFav() = runBlocking{
        detailMovieModel.addFavorite(sampleDataMovie)
        detailMovieModel.deleteFavorite(sampleDataMovie)
        detailMovieModel.isFavorite(sampleDataMovie)
        detailMovieModel.isFavorite.observeForever(observerFav)
        val value = detailMovieModel.isFavorite.value
        verify(repositoryDatabase).addFavoriteMovie(sampleDataMovie)
        verify(repositoryDatabase).deleteFavoriteMovie(sampleDataMovie)
        verify(repositoryDatabase).isFavoriteMovie(sampleDataMovie)
        verify(observerFav).onChanged(value)
    }
}

